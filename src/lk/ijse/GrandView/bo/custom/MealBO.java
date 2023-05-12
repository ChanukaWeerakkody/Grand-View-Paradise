package lk.ijse.GrandView.bo.custom;

import lk.ijse.GrandView.bo.SuperBO;
import lk.ijse.GrandView.dto.MealDTO;
import lk.ijse.GrandView.entity.Meal;

import java.sql.SQLException;
import java.util.ArrayList;

public interface MealBO extends SuperBO {
    ArrayList<MealDTO> getAllMeal() throws SQLException, ClassNotFoundException;
    void saveMeal(MealDTO dto) throws SQLException, ClassNotFoundException;
    boolean existsMeal(String id) throws SQLException, ClassNotFoundException;
    MealDTO searchMeal(String id) throws SQLException, ClassNotFoundException;
    boolean deleteMeal(String id) throws SQLException, ClassNotFoundException;
    void updateMeal(MealDTO dto) throws SQLException, ClassNotFoundException;
    MealDTO searchMealPrice(String s) throws SQLException, ClassNotFoundException;
    ArrayList<String> loadMealId() throws SQLException, ClassNotFoundException;
}
