package lk.ijse.GrandView.dao.custom.impl;

import lk.ijse.GrandView.dao.custom.PaymentDAO;
import lk.ijse.GrandView.entity.MealDetail;
import lk.ijse.GrandView.entity.Payment;
import lk.ijse.GrandView.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentDAOImpl implements PaymentDAO {
    @Override
    public ArrayList<Payment> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM payment");
        ArrayList<Payment> allPayment=new ArrayList<>();
        while (rst.next()){
            allPayment.add(new Payment(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4), rst.getDouble(5), rst.getString(6),rst.getDouble(7),rst.getDouble(8)));
        }
        return allPayment;
    }

    @Override
    public boolean save(Payment dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("INSERT INTO payment (payment_id,guest_id,meal_id, room_id,total,billed_date,payment,balance) VALUES (?,?,?,?,?,?,?,?)",dto.getPaymentId(),dto.getGuestId(),dto.getMealId(),dto.getRoomId(),dto.getTotal(),dto.getDate(),dto.getPayment(),dto.getBalance());
    }

    @Override
    public boolean update(Payment dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Payment search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeQuery("SELECT payment_id FROM payment WHERE payment_id=?", s).next();
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }
}
