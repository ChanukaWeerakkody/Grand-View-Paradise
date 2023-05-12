package lk.ijse.GrandView.bo.custom;

import lk.ijse.GrandView.bo.SuperBO;
import lk.ijse.GrandView.dto.EmployeeDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeBO extends SuperBO {
    ArrayList<EmployeeDTO> getAllEmployee() throws SQLException, ClassNotFoundException;
    void saveEmployee(EmployeeDTO dto) throws SQLException, ClassNotFoundException;
    boolean existsEmployee(String id) throws SQLException, ClassNotFoundException;
    EmployeeDTO searchEmployee(String id) throws SQLException, ClassNotFoundException;
    boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException;
    void updateEmployee(EmployeeDTO dto) throws SQLException, ClassNotFoundException;
}
