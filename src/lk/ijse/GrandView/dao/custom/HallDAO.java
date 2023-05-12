package lk.ijse.GrandView.dao.custom;

import lk.ijse.GrandView.dao.CrudDAO;
import lk.ijse.GrandView.entity.Hall;

import java.sql.SQLException;
import java.util.ArrayList;

public interface HallDAO extends CrudDAO<Hall,String> {
    int checkAvailableHalls() throws SQLException, ClassNotFoundException;
    int checkBookedHalls() throws SQLException, ClassNotFoundException;
    ArrayList<String> loadHallIds() throws SQLException, ClassNotFoundException;
}
