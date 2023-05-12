package lk.ijse.GrandView.bo.custom.impl;

import lk.ijse.GrandView.bo.custom.MealBO;
import lk.ijse.GrandView.dao.DAOFactory;
import lk.ijse.GrandView.dao.custom.HallDAO;
import lk.ijse.GrandView.dao.custom.MealDAO;
import lk.ijse.GrandView.dto.HallDTO;
import lk.ijse.GrandView.dto.MealDTO;
import lk.ijse.GrandView.entity.Hall;
import lk.ijse.GrandView.entity.Meal;

import java.sql.SQLException;
import java.util.ArrayList;

public class MealBOImpl implements MealBO {
    private MealDAO mealDAO=(MealDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.MEAL);
    @Override
    public ArrayList<MealDTO> getAllMeal() throws SQLException, ClassNotFoundException {
        ArrayList<Meal> all = mealDAO.getAll();
        ArrayList<MealDTO> allMeal = new ArrayList<>();
        for (Meal meal : all) {
            allMeal.add(new MealDTO(meal.getMealID(), meal.getType(), meal.getDesc(), meal.getPrice()));
        }
        return allMeal;
    }

    @Override
    public void saveMeal(MealDTO dto) throws SQLException, ClassNotFoundException {
        mealDAO.save(new Meal(dto.getMealID(), dto.getType(), dto.getDesc(), dto.getPrice()));
    }

    @Override
    public boolean existsMeal(String id) throws SQLException, ClassNotFoundException {
        return mealDAO.exist(id);
    }

    @Override
    public MealDTO searchMeal(String id) throws SQLException, ClassNotFoundException {
        Meal ent = mealDAO.search(id);
        return new MealDTO(ent.getMealID(), ent.getType(), ent.getDesc(), ent.getPrice());
    }

    @Override
    public boolean deleteMeal(String id) throws SQLException, ClassNotFoundException {
        return mealDAO.delete(id);
    }

    @Override
    public void updateMeal(MealDTO dto) throws SQLException, ClassNotFoundException {
        mealDAO.update(new Meal(dto.getMealID(), dto.getType(), dto.getDesc(), dto.getPrice()));
    }

    @Override
    public MealDTO searchMealPrice(String s) throws SQLException, ClassNotFoundException {
        Meal ent = mealDAO.search(s);
        return new MealDTO(ent.getMealID(),ent.getDesc(), ent.getPrice());
    }

    @Override
    public ArrayList<String> loadMealId() throws SQLException, ClassNotFoundException {
        return mealDAO.loadMealIds();
    }
}
