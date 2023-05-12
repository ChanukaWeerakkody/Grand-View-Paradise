package lk.ijse.GrandView.dao.custom.impl;

import lk.ijse.GrandView.dao.custom.EmployeeDAO;
import lk.ijse.GrandView.entity.Employee;
import lk.ijse.GrandView.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public ArrayList<Employee> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM employee");
        ArrayList<Employee> allEmployee=new ArrayList<>();
        while (rst.next()){
            allEmployee.add(new Employee(rst.getString(1),rst.getString(2),rst.getString(3),rst.getInt(4)));
        }
        return allEmployee;
    }

    @Override
    public boolean save(Employee dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("INSERT INTO employee (emp_id,emp_name, address,contact_number) VALUES (?,?,?,?)",dto.getId(),dto.getName(),dto.getAddress(),dto.getContact());
    }

    @Override
    public boolean update(Employee dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("UPDATE employee SET emp_name=?, address=?,contact_number=? WHERE emp_id=?",dto.getName(),dto.getAddress(),dto.getContact(),dto.getId());

    }

    @Override
    public Employee search(String s) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM employee WHERE emp_id = ?", s);
        if(rst.next()){
            return new Employee(rst.getString(1), rst.getString(2), rst.getString(3), rst.getInt(4));
        }
        return null;
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeQuery("SELECT emp_id FROM employee WHERE emp_id=?", s).next();
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("DELETE FROM employee WHERE emp_id=?",s);
    }
}
