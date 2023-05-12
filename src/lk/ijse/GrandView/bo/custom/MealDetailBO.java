package lk.ijse.GrandView.bo.custom;

import lk.ijse.GrandView.bo.SuperBO;
import lk.ijse.GrandView.dto.EmployeeDTO;
import lk.ijse.GrandView.dto.MealDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface MealDetailBO extends SuperBO {
    ArrayList<MealDetailDTO> getAllMealDetail() throws SQLException, ClassNotFoundException;
    void saveMealDetail(MealDetailDTO dto) throws SQLException, ClassNotFoundException;
    boolean existsMealDetail(String id) throws SQLException, ClassNotFoundException;
    MealDetailDTO searchMealDetail(String id) throws SQLException, ClassNotFoundException;
    boolean deleteMealDetail(String id) throws SQLException, ClassNotFoundException;
    void updateMealDetail(MealDetailDTO dto) throws SQLException, ClassNotFoundException;
    double getTotalFromGuestMeal(String id) throws SQLException,ClassNotFoundException;
    String generateNewOrderId() throws SQLException, ClassNotFoundException;
}
