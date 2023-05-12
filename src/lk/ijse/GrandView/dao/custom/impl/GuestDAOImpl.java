package lk.ijse.GrandView.dao.custom.impl;

import lk.ijse.GrandView.dao.custom.GuestDAO;
import lk.ijse.GrandView.entity.Guest;
import lk.ijse.GrandView.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GuestDAOImpl implements GuestDAO {
    @Override
    public ArrayList<Guest> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM guest");
        ArrayList<Guest> allGuest=new ArrayList<>();
        while (rst.next()){
            allGuest.add(new Guest(rst.getString(1),rst.getString(2),rst.getString(3),rst.getInt(4)));
        }
        return allGuest;
    }

    @Override
    public boolean save(Guest dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("INSERT INTO guest (guest_id,name, address,contact) VALUES (?,?,?,?)",dto.getGuestId(),dto.getName(),dto.getAddress(),dto.getContact());
    }

    @Override
    public boolean update(Guest dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("UPDATE guest SET name=?, address=?,contact=? WHERE guest_id=?",dto.getName(),dto.getAddress(),dto.getContact(),dto.getGuestId());
    }

    @Override
    public Guest search(String s) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM guest WHERE guest_id = ?", s);
        if(rst.next()){
            return new Guest(rst.getString(1), rst.getString(2), rst.getString(3), rst.getInt(4));
        }
        return null;
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeQuery("SELECT guest_id FROM guest WHERE guest_id=?", s).next();
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("DELETE FROM guest WHERE guest_id=?",s);
    }

    @Override
    public ArrayList<String> loadGuestIds() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT guest_id FROM guest");
        ArrayList<String> codeList = new ArrayList<>();
        while (rst.next()) {
            codeList.add(rst.getString(1));
        }
        return codeList;
    }
}
