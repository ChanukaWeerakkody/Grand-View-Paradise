package lk.ijse.GrandView.dao.custom.impl;

import lk.ijse.GrandView.dao.custom.RoomDetailDAO;
import lk.ijse.GrandView.entity.RoomDetails;
import lk.ijse.GrandView.util.SQLUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoomDetailDAOImpl implements RoomDetailDAO {
    @Override
    public ArrayList<RoomDetails> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM room_details");
        ArrayList<RoomDetails> allRooms=new ArrayList<>();
        while (rst.next()){
            allRooms.add(new RoomDetails(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6), rst.getDouble(7)));
        }
        return allRooms;
    }

    @Override
    public boolean save(RoomDetails dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("INSERT INTO room_details (reserv_id,guest_id, hall_id,room_id,in_date,out_date,price) VALUES (?,?,?,?,?,?,?)",dto.getResId(),dto.getGuestId(),dto.getHallId(),dto.getRoomId(),dto.getInDate(),dto.getOutDate(),dto.getPrice());
    }

    @Override
    public boolean update(RoomDetails dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("UPDATE room_details SET guest_id=?, hall_id=?,room_id=?,in_date=?,out_date=?,price=? WHERE reserv_id=?",dto.getGuestId(),dto.getHallId(),dto.getRoomId(),dto.getInDate(),dto.getOutDate(),dto.getPrice(),dto.getResId());
    }

    @Override
    public RoomDetails search(String s) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM room_details WHERE reserv_id = ?", s);
        if(rst.next()){
            return new RoomDetails(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6), rst.getDouble(7));
        }
        return null;
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeQuery("SELECT reserv_id FROM room_details WHERE reserv_id=?", s).next();
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("DELETE FROM room_details WHERE reserv_id=?",s);
    }
}
