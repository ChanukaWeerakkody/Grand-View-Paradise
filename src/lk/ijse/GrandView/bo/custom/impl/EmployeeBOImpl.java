package lk.ijse.GrandView.bo.custom.impl;

import lk.ijse.GrandView.bo.custom.EmployeeBO;
import lk.ijse.GrandView.dao.DAOFactory;
import lk.ijse.GrandView.dao.custom.EmployeeDAO;
import lk.ijse.GrandView.dto.EmployeeDTO;
import lk.ijse.GrandView.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeBOImpl implements EmployeeBO {
    private EmployeeDAO employeeDAO=(EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);
    @Override
    public ArrayList<EmployeeDTO> getAllEmployee() throws SQLException, ClassNotFoundException {
        ArrayList<Employee> all = employeeDAO.getAll();
        ArrayList<EmployeeDTO> allEmployee = new ArrayList<>();
        for (Employee employee : all) {
            allEmployee.add(new EmployeeDTO(employee.getId(), employee.getName(), employee.getAddress(), employee.getContact()));
        }
        return allEmployee;
    }

    @Override
    public void saveEmployee(EmployeeDTO dto) throws SQLException, ClassNotFoundException {
        employeeDAO.save(new Employee(dto.getId(), dto.getName(), dto.getAddress(), dto.getContact()));
    }

    @Override
    public boolean existsEmployee(String id) throws SQLException, ClassNotFoundException {
        return employeeDAO.exist(id);
    }

    @Override
    public EmployeeDTO searchEmployee(String id) throws SQLException, ClassNotFoundException {
        Employee ent = employeeDAO.search(id);
        return new EmployeeDTO(ent.getId(), ent.getName(), ent.getAddress(), ent.getContact());
    }

    @Override
    public boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException {
        return employeeDAO.delete(id);
    }

    @Override
    public void updateEmployee(EmployeeDTO dto) throws SQLException, ClassNotFoundException {
        employeeDAO.update(new Employee(dto.getId(), dto.getName(), dto.getAddress(), dto.getContact()));
    }
}
