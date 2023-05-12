package lk.ijse.GrandView.bo.custom.impl;

import lk.ijse.GrandView.bo.custom.MealDetailBO;
import lk.ijse.GrandView.dao.DAOFactory;
import lk.ijse.GrandView.dao.custom.EmployeeDAO;
import lk.ijse.GrandView.dao.custom.MealDetailDAO;
import lk.ijse.GrandView.dto.EmployeeDTO;
import lk.ijse.GrandView.dto.MealDetailDTO;
import lk.ijse.GrandView.entity.Employee;
import lk.ijse.GrandView.entity.MealDetail;

import java.sql.SQLException;
import java.util.ArrayList;

public class MealDetailBOImpl implements MealDetailBO {
    private MealDetailDAO mealDetailDAO=(MealDetailDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.MEAL_DETAIL);
    @Override
    public ArrayList<MealDetailDTO> getAllMealDetail() throws SQLException, ClassNotFoundException {
        ArrayList<MealDetail> all = mealDetailDAO.getAll();
        ArrayList<MealDetailDTO> allMeal = new ArrayList<>();
        for (MealDetail mealDetail : all) {
            allMeal.add(new MealDetailDTO(mealDetail.getOrderId(), mealDetail.getMealId(), mealDetail.getGuestId(), mealDetail.getDesc(),mealDetail.getQty(),mealDetail.getPrice()));
        }
        return allMeal;
    }

    @Override
    public void saveMealDetail(MealDetailDTO dto) throws SQLException, ClassNotFoundException {
        mealDetailDAO.save(new MealDetail(dto.getOrderId(), dto.getMealId(), dto.getGuestId(), dto.getDesc(),dto.getQty(),dto.getPrice()));
    }

    @Override
    public boolean existsMealDetail(String id) throws SQLException, ClassNotFoundException {
        return mealDetailDAO.exist(id);
    }

    @Override
    public MealDetailDTO searchMealDetail(String id) throws SQLException, ClassNotFoundException {
        MealDetail ent = mealDetailDAO.search(id);
        return new MealDetailDTO(ent.getOrderId(), ent.getMealId(), ent.getGuestId(), ent.getDesc(),ent.getQty(),ent.getPrice());
    }

    @Override
    public boolean deleteMealDetail(String id) throws SQLException, ClassNotFoundException {
        return mealDetailDAO.delete(id);
    }

    @Override
    public void updateMealDetail(MealDetailDTO dto) throws SQLException, ClassNotFoundException {
        mealDetailDAO.update(new MealDetail(dto.getOrderId(), dto.getMealId(), dto.getGuestId(), dto.getDesc(),dto.getQty(),dto.getPrice()));
    }

    @Override
    public double getTotalFromGuestMeal(String id) throws SQLException, ClassNotFoundException {
        return mealDetailDAO.getTotalFromGuest(id);
    }

    @Override
    public String generateNewOrderId() throws SQLException, ClassNotFoundException {
        return mealDetailDAO.generateNewId();
    }
}
