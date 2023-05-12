package lk.ijse.GrandView.dao.custom;

import lk.ijse.GrandView.dao.CrudDAO;
import lk.ijse.GrandView.entity.Guest;

import java.sql.SQLException;
import java.util.ArrayList;

public interface GuestDAO extends CrudDAO<Guest,String> {
    ArrayList<String> loadGuestIds() throws SQLException, ClassNotFoundException;
}
