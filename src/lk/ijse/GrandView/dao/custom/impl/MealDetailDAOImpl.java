package lk.ijse.GrandView.dao.custom.impl;

import lk.ijse.GrandView.dao.custom.MealDetailDAO;
import lk.ijse.GrandView.entity.MealDetail;
import lk.ijse.GrandView.util.SQLUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MealDetailDAOImpl implements MealDetailDAO {

    @Override
    public ArrayList<MealDetail> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM mealDetails");
        ArrayList<MealDetail> allMeal=new ArrayList<>();
        while (rst.next()){
            allMeal.add(new MealDetail(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4), rst.getInt(5), rst.getDouble(6)));
        }
        return allMeal;
    }

    @Override
    public boolean save(MealDetail dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("INSERT INTO mealDetails (order_id,meal_id,guest_id, description,qty,price) VALUES (?,?,?,?,?,?)",dto.getOrderId(),dto.getMealId(),dto.getGuestId(),dto.getDesc(),dto.getQty(),dto.getPrice());
    }

    @Override
    public boolean update(MealDetail dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("UPDATE mealDetails SET meal_id=?,guest_id=?, description=?, qty=?, price=? WHERE order_id=?",dto.getMealId(),dto.getGuestId(),dto.getDesc(),dto.getQty(),dto.getPrice(),dto.getOrderId());
    }

    @Override
    public MealDetail search(String s) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM mealDetails WHERE order_id = ?", s);
        if(rst.next()){
            return new MealDetail(rst.getString(1),rst.getString(2), rst.getString(3), rst.getString(4), rst.getInt(5), rst.getDouble(6));
        }
        return null;
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeQuery("SELECT order_id FROM mealDetails WHERE order_id=?", s).next();
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("DELETE FROM mealDetails WHERE order_id=?",s);
    }

    @Override
    public double getTotalFromGuest(String s) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT SUM(price) FROM mealDetails WHERE guest_id=?", s);
        if(rst.next()){
            return rst.getDouble(1);
        }
        return 0;
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("Select order_id from  mealDetails order by order_id desc limit 1");
        return rst.next() ? rst.getString("order_id"):null;
    }
}
