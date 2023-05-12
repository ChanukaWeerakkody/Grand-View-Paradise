package lk.ijse.GrandView.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import lk.ijse.GrandView.bo.BOFactory;
import lk.ijse.GrandView.bo.custom.impl.MealBOImpl;
import lk.ijse.GrandView.bo.custom.impl.MealDetailBOImpl;
import lk.ijse.GrandView.dto.MealDTO;
import lk.ijse.GrandView.dto.MealDetailDTO;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class MealDetailController {
    public AnchorPane subPane;
    public Label lblPrice;
    public JFXTextField txtDesc;
    public JFXTextField txtGuestId;
    public JFXButton btnAdd;
    public Label lblTime;
    public JFXTextField txtQty;
    public JFXTextField txtPrice;
    public JFXComboBox cmbID;
    public Label lblOrderId;
    private double totalPrice;
    private MealDetailBOImpl mealDetailBO=(MealDetailBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.MEAL_DETAIL);
    private MealBOImpl mealBO=(MealBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.MEAL);

    public void initialize(){
        loadOrderTime();
        loadMealIds();
        generateNewOrderId();
    }

    private void generateNewOrderId() {
        try {
            String lastOrderId=mealDetailBO.generateNewOrderId();
            lblOrderId.setText(lastOrderId);
            if (lastOrderId == null) {
                lblOrderId.setText("O001");
            } else {
                String[] split = lastOrderId.split("[O]");
                int lastDigits = Integer.parseInt(split[1]);
                lastDigits++;
                String newOrderId = String.format("O%03d", lastDigits);
                lblOrderId.setText(newOrderId);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadMealIds() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> idList = mealBO.loadMealId();
            for (String id : idList) {
                observableList.add(id);
            }
            cmbID.setItems(observableList);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void clearOnAction(ActionEvent actionEvent) {
        txtDesc.clear();
        txtGuestId.clear();
        txtQty.clear();
    }

    public void addOnAction(ActionEvent actionEvent) {
        String orderId=lblOrderId.getText();
        String mealId=String.valueOf(cmbID.getValue());
        String guestId=txtGuestId.getText();
        String desc=txtDesc.getText();
        int qty=Integer.parseInt(txtQty.getText());
        double price=Double.parseDouble(txtPrice.getText());
        totalPrice=price*qty;

        if(!txtGuestId.getText().matches("^(G)[-]?[0-9]{3}$")) {
            new Alert(Alert.AlertType.ERROR, "Invalid id").show();
            txtGuestId.requestFocus();
            return;
        }else if (!txtQty.getText().matches("[0-9]+")) {
            new Alert(Alert.AlertType.ERROR, "Invalid Qty").show();
            txtQty.requestFocus();
            return;
        }
        lblPrice.setText(String.valueOf(totalPrice));
        if(btnAdd.getText().equalsIgnoreCase("ADD")){
            try {
                if(existMealDetail(orderId)){
                    new Alert(Alert.AlertType.ERROR, orderId + " already exists").show();
                }
                mealDetailBO.saveMealDetail(new MealDetailDTO(orderId,mealId,guestId,desc,qty,totalPrice));
                new Alert(Alert.AlertType.CONFIRMATION, "Save Order successfully").show();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateOnAction(ActionEvent actionEvent) {
    }

    public void searchOnAction(ActionEvent actionEvent) {
    }

    public void deleteOnAction(ActionEvent actionEvent) {
    }

    boolean existMealDetail(String id) throws SQLException, ClassNotFoundException {
        return mealDetailBO.existsMealDetail(id);
    }
    private void loadOrderTime(){
        lblTime.setText(String.valueOf(LocalDate.now()));
        DateFormat df = new SimpleDateFormat(" HH:mm:ss");
        Date dateobj = new Date();
        lblTime.setText(df.format(dateobj));
    }

    public void cmbIdOnAction(ActionEvent actionEvent) {
        String id = String.valueOf(cmbID.getValue());
        try {
            MealDTO mealDTO = mealBO.searchMealPrice(id);
            fillmealFields(mealDTO);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void fillmealFields(MealDTO mealDTO) {
        txtDesc.setText(mealDTO.getDesc());
        txtPrice.setText(String.valueOf(mealDTO.getPrice()));
    }
}
