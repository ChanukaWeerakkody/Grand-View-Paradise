package lk.ijse.GrandView.dao.custom.impl;

import lk.ijse.GrandView.dao.custom.MealDAO;
import lk.ijse.GrandView.entity.Meal;
import lk.ijse.GrandView.util.SQLUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MealDAOImpl implements MealDAO {
    @Override
    public ArrayList<Meal> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM meal");
        ArrayList<Meal> allMeal=new ArrayList<>();
        while (rst.next()){
            allMeal.add(new Meal(rst.getString(1),rst.getString(2),rst.getString(3),rst.getDouble(4)));
        }
        return allMeal;
    }

    @Override
    public boolean save(Meal dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("INSERT INTO meal (meal_id,type, description,price) VALUES (?,?,?,?)",dto.getMealID(),dto.getType(),dto.getDesc(),dto.getPrice());
    }

    @Override
    public boolean update(Meal dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("UPDATE meal SET type=?, description=?,price=? WHERE meal_id=?",dto.getType(),dto.getDesc(),dto.getPrice(),dto.getMealID());
    }

    @Override
    public Meal search(String s) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM meal WHERE meal_id = ?", s);
        if(rst.next()){
            return new Meal(rst.getString(1), rst.getString(2), rst.getString(3), rst.getDouble(4));
        }
        return null;
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeQuery("SELECT meal_id FROM meal WHERE meal_id=?", s).next();
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("DELETE FROM meal WHERE meal_id=?",s);
    }
    @Override
    public Meal searchMeal(String s) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM meal WHERE meal_id = ?", s);
        if(rst.next()){
            return new Meal(rst.getString(1), rst.getString(2), rst.getDouble(3));
        }
        return null;
    }
    @Override
    public ArrayList<String> loadMealIds() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT meal_id FROM meal");
        ArrayList<String> codeList = new ArrayList<>();
        while (rst.next()) {
            codeList.add(rst.getString(1));
        }
        return codeList;
    }
}
