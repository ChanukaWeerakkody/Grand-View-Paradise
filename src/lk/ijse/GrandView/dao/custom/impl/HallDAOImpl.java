package lk.ijse.GrandView.dao.custom.impl;

import lk.ijse.GrandView.dao.custom.HallDAO;
import lk.ijse.GrandView.entity.Hall;
import lk.ijse.GrandView.util.SQLUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HallDAOImpl implements HallDAO {
    @Override
    public ArrayList<Hall> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM hall");
        ArrayList<Hall> allHall=new ArrayList<>();
        while (rst.next()){
            allHall.add(new Hall(rst.getString(1),rst.getString(2),rst.getString(3),rst.getDouble(4)));
        }
        return allHall;
    }

    @Override
    public boolean save(Hall dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("INSERT INTO hall (hall_id,name, type,price) VALUES (?,?,?,?)",dto.getHallId(),dto.getName(),dto.getType(),dto.getPrice());
    }

    @Override
    public boolean update(Hall dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("UPDATE hall SET name=?, type=?,price=? WHERE hall_id=?",dto.getName(),dto.getType(),dto.getPrice(),dto.getHallId());
    }

    @Override
    public Hall search(String s) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM hall WHERE hall_id = ?", s);
        if(rst.next()){
            return new Hall(rst.getString(1), rst.getString(2), rst.getString(3), rst.getDouble(4));
        }
        return null;
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeQuery("SELECT hall_id FROM hall WHERE hall_id=?", s).next();
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("DELETE FROM hall WHERE hall_id=?",s);
    }

    @Override
    public int checkAvailableHalls() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("select count(*) from hall where type='Available'");
        if (rst.next()){
            return  rst.getInt(1);
        }
        return 0;
    }

    @Override
    public int checkBookedHalls() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("select count(*) from hall where type='Unavailable'");
        if (rst.next()){
            return  rst.getInt(1);
        }
        return 0;
    }

    @Override
    public ArrayList<String> loadHallIds() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT hall_id FROM hall");
        ArrayList<String> codeList = new ArrayList<>();
        while (rst.next()) {
            codeList.add(rst.getString(1));
        }
        return codeList;
    }
}
