package lk.ijse.GrandView.dao.custom;

import lk.ijse.GrandView.dao.CrudDAO;

import lk.ijse.GrandView.entity.MealDetail;

import java.sql.SQLException;

public interface MealDetailDAO extends CrudDAO<MealDetail,String> {
    double getTotalFromGuest(String s) throws SQLException, ClassNotFoundException;
    String generateNewId() throws SQLException, ClassNotFoundException;
}
