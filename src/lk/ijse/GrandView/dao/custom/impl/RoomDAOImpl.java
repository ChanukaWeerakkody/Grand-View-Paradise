package lk.ijse.GrandView.dao.custom.impl;

import lk.ijse.GrandView.dao.custom.RoomDAO;
import lk.ijse.GrandView.entity.Room;
import lk.ijse.GrandView.util.SQLUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoomDAOImpl implements RoomDAO {

    @Override
    public ArrayList<Room> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM room");
        ArrayList<Room> allRoom=new ArrayList<>();
        while (rst.next()){
            allRoom.add(new Room(rst.getString(1),rst.getString(2),rst.getString(3),rst.getDouble(4), rst.getString(5)));
        }
        return allRoom;
    }

    @Override
    public boolean save(Room dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("INSERT INTO room (room_id,status, room_type,price,hall_id) VALUES (?,?,?,?,?)",dto.getRoomId(),dto.getStatus(),dto.getType(),dto.getPrice(),dto.getHallId());
    }

    @Override
    public boolean update(Room dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("UPDATE room SET status=?, room_type=?,price=? ,hall_id=? WHERE room_id=?",dto.getStatus(),dto.getType(),dto.getPrice(),dto.getHallId(),dto.getRoomId());
    }

    @Override
    public Room search(String s) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM room WHERE room_id = ?", s);
        if(rst.next()){
            return new Room(rst.getString(1),rst.getString(2),rst.getString(3),rst.getDouble(4), rst.getString(5));
        }
        return null;
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeQuery("SELECT room_id FROM room WHERE room_id=?", s).next();
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("DELETE FROM room WHERE room_id=?",s);
    }
    @Override
    public int checkAvailableRooms() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("select count(*) from room where status='Available'");
        if (rst.next()){
            return  rst.getInt(1);
        }
        return 0;
    }

    @Override
    public int checkBookedRooms() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("select count(*) from room where status='Unavailable'");
        if (rst.next()){
            return  rst.getInt(1);
        }
        return 0;
    }

    @Override
    public int activeRooms() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("select count(*) from room");
        if (rst.next()){
            return  rst.getInt(1);
        }
        return 0;
    }

    @Override
    public ArrayList<String> loadRoomIds() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT room_id FROM room");
        ArrayList<String> codeList = new ArrayList<>();
        while (rst.next()) {
            codeList.add(rst.getString(1));
        }
        return codeList;
    }
}
