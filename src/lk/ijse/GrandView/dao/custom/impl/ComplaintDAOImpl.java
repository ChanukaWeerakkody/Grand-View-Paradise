package lk.ijse.GrandView.dao.custom.impl;

import lk.ijse.GrandView.dao.custom.ComplaintDAO;
import lk.ijse.GrandView.entity.Complaint;
import lk.ijse.GrandView.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ComplaintDAOImpl implements ComplaintDAO {
    @Override
    public ArrayList<Complaint> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM complaint");
        ArrayList<Complaint> allComplaint=new ArrayList<>();
        while (rst.next()){
            allComplaint.add(new Complaint(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5), rst.getString(6)));
        }
        return allComplaint;
    }

    @Override
    public boolean save(Complaint dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("INSERT INTO complaint (com_id,guest_id,  description,hall_id,room_id,date) VALUES (?,?,?,?,?,?)",dto.getComID(),dto.getGuestId(),dto.getDesc(),dto.getHallId(),dto.getRoomId(),dto.getDate());
    }

    @Override
    public boolean update(Complaint dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("UPDATE complaint SET guest_id=?, description=?,hall_id=?,room_id=?,date=? WHERE com_id=?",dto.getGuestId(),dto.getDesc(),dto.getHallId(),dto.getRoomId(),dto.getDate(),dto.getComID());
    }

    @Override
    public Complaint search(String s) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM complaint WHERE com_id = ?", s);
        if(rst.next()){
            return new Complaint(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4),rst.getString(5),rst.getString(6));
        }
        return null;
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeQuery("SELECT com_id FROM complaint WHERE com_id=?", s).next();
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("DELETE FROM complaint WHERE com_id=?",s);
    }

    @Override
    public int checkActiveComplaint() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("select COUNT(*) from complaint");
        if (rst.next()){
            return  rst.getInt(1);
        }
        return 0;
    }
}
