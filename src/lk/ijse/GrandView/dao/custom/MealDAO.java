package lk.ijse.GrandView.dao.custom;

import lk.ijse.GrandView.dao.CrudDAO;
import lk.ijse.GrandView.entity.Meal;

import java.sql.SQLException;
import java.util.ArrayList;

public interface MealDAO extends CrudDAO<Meal,String> {
    ArrayList<String> loadMealIds() throws SQLException, ClassNotFoundException;
    Meal searchMeal(String s) throws SQLException, ClassNotFoundException;

}
