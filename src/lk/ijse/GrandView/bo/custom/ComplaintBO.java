package lk.ijse.GrandView.bo.custom;

import lk.ijse.GrandView.bo.SuperBO;
import lk.ijse.GrandView.dto.ComplaintDTO;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ComplaintBO extends SuperBO {
    ArrayList<ComplaintDTO> getAllComplaint() throws SQLException, ClassNotFoundException;
    void saveComplaint(ComplaintDTO dto) throws SQLException, ClassNotFoundException;
    boolean existsComplaint(String id) throws SQLException, ClassNotFoundException;
    ComplaintDTO searchComplaint(String id) throws SQLException, ClassNotFoundException;
    boolean deleteComplaint(String id) throws SQLException, ClassNotFoundException;
    void updateComplaint(ComplaintDTO dto) throws SQLException, ClassNotFoundException;
    int allComplaint() throws SQLException, ClassNotFoundException;
}
