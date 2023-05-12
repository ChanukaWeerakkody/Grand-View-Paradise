package lk.ijse.GrandView.dao.custom;

import lk.ijse.GrandView.dao.CrudDAO;
import lk.ijse.GrandView.entity.Room;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RoomDAO extends CrudDAO<Room,String > {
    int checkAvailableRooms() throws SQLException, ClassNotFoundException;
    int checkBookedRooms() throws SQLException, ClassNotFoundException;
    int activeRooms() throws SQLException, ClassNotFoundException;
    ArrayList<String> loadRoomIds() throws SQLException, ClassNotFoundException;
}
