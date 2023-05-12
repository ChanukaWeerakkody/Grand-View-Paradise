package lk.ijse.GrandView.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.GrandView.bo.BOFactory;
import lk.ijse.GrandView.bo.custom.impl.EmployeeBOImpl;
import lk.ijse.GrandView.bo.custom.impl.MealBOImpl;
import lk.ijse.GrandView.dto.EmployeeDTO;
import lk.ijse.GrandView.dto.MealDTO;
import lk.ijse.GrandView.view.tdm.EmployeeTM;
import lk.ijse.GrandView.view.tdm.MealTM;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class MealController {
    public AnchorPane subPane;
    public JFXTextField txtId;
    public JFXTextField txtPrice;
    public JFXTextField txtDesc;
    public JFXTextField txtType;
    public JFXButton btnAdd;
    public TableView tblMeals;
    public TableColumn colId;
    public TableColumn colType;
    public TableColumn colDesc;
    public TableColumn colPrice;
    public Label lblTime;
    private MealBOImpl mealBO=(MealBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.MEAL);

    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("mealID"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colDesc.setCellValueFactory(new PropertyValueFactory<>("desc"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        try {
            setEmployeeInToTable();
            loadOrderTime();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void setEmployeeInToTable() throws SQLException, ClassNotFoundException {
        tblMeals.getItems().clear();
        try {
            ArrayList<MealDTO> allMeal = mealBO.getAllMeal();
            for(MealDTO meal: allMeal){
                tblMeals.getItems().add(new MealTM(meal.getMealID(), meal.getType(), meal.getDesc(),meal.getPrice()));
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    public void clearOnAction(ActionEvent actionEvent) {
        txtId.clear();
        txtType.clear();
        txtDesc.clear();
        txtPrice.clear();
    }
    boolean existMeal(String id) throws SQLException, ClassNotFoundException {
        return mealBO.existsMeal(id);
    }
    public void addOnAction(ActionEvent actionEvent) {
        String id=txtId.getText();
        String type=txtType.getText();
        String desc=txtDesc.getText();
        double price=Double.parseDouble(txtPrice.getText());
        if(!id.matches("^(M)[-]?[0-9]{3}$")) {
            new Alert(Alert.AlertType.ERROR, "Invalid id").show();
            txtId.requestFocus();
            return;
        }else if(!type.matches("^[A-z ]{5,30}$")){
            new Alert(Alert.AlertType.ERROR, "Invalid name").show();
            txtType.requestFocus();
            return;
        }else if (!desc.matches("^[A-z ]{5,30}$")) {
            new Alert(Alert.AlertType.ERROR, "Invalid name").show();
            txtDesc.requestFocus();
            return;
        }else if(!txtPrice.getText().matches("^[1-9][0-9]{1,9}$")){
            new Alert(Alert.AlertType.ERROR, "Invalid price").show();
            txtPrice.requestFocus();
            return;
        }
        if(btnAdd.getText().equalsIgnoreCase("ADD")){
            try {
                if(existMeal(id)){
                    new Alert(Alert.AlertType.ERROR, id + " already exists").show();
                }
                mealBO.saveMeal(new MealDTO(id,type,desc,price));
                new Alert(Alert.AlertType.CONFIRMATION, "Save meal successfully").show();
                tblMeals.getItems().add(new MealTM(id, type, desc,price));
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
    private void loadOrderTime(){
        lblTime.setText(String.valueOf(LocalDate.now()));
        DateFormat df = new SimpleDateFormat(" HH:mm:ss");
        Date dateobj = new Date();
        lblTime.setText(df.format(dateobj));
    }
}
