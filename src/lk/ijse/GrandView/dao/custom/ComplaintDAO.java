package lk.ijse.GrandView.dao.custom;


import lk.ijse.GrandView.dao.CrudDAO;
import lk.ijse.GrandView.entity.Complaint;

import java.sql.SQLException;

public interface ComplaintDAO extends CrudDAO<Complaint,String> {
    int checkActiveComplaint() throws SQLException, ClassNotFoundException;
}
