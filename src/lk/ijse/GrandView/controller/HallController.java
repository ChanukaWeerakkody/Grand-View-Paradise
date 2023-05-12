package lk.ijse.GrandView.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.GrandView.bo.BOFactory;
import lk.ijse.GrandView.bo.custom.impl.HallBOImpl;
import lk.ijse.GrandView.dto.HallDTO;
import lk.ijse.GrandView.dto.UserDTO;
import lk.ijse.GrandView.view.tdm.HallTM;
import lk.ijse.GrandView.view.tdm.UserTM;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HallController {
    public AnchorPane subPane;
    public JFXComboBox cmbStatus;
    public JFXTextField txtHallId;
    public JFXTextField txtPrice;
    public JFXTextField txtName;
    public JFXButton btnClear;
    public JFXButton btnAdd;
    public JFXButton btnUpdate;
    public JFXButton btnSearch;
    public JFXButton btnDelete;
    public TableView tblHall;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colStatus;
    public TableColumn colPrice;
    public Label lblTime;
    private String [] roleList={"Available","Unavailable"};
    private HallBOImpl hallBO=(HallBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.HALL);

    public void initialize(){
        colId.setCellValueFactory(new PropertyValueFactory<>("hallId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("type"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        try {
            setHallInToTable();
            statusOnAction();
            loadOrderTime();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void setHallInToTable() throws SQLException, ClassNotFoundException {
        tblHall.getItems().clear();
        try {
            ArrayList<HallDTO> allHall=hallBO.getAllHall();
            for(HallDTO hall: allHall){
                tblHall.getItems().add(new HallTM(hall.getHallId(), hall.getName(), hall.getType(),hall.getPrice()));
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    public void statusOnAction() {
        List<String> lists=new ArrayList<>();
        for(String role : roleList){
            lists.add(role);
        }
        ObservableList roleData= FXCollections.observableArrayList(lists);
        cmbStatus.setItems(roleData);
    }

    public void clearOnAction(ActionEvent actionEvent) {
        txtHallId.clear();
        txtName.clear();
        txtPrice.clear();
    }

    public void addOnAction(ActionEvent actionEvent) {
        String role=(String) cmbStatus.getValue();
        if(!txtHallId.getText().matches("^(H)[-]?[0-9]{3}$")) {
            new Alert(Alert.AlertType.ERROR, "Invalid id").show();
            txtHallId.requestFocus();
            return;
        }else if (!txtName.getText().matches("^[A-z ]{5,30}$")) {
            new Alert(Alert.AlertType.ERROR, "Name should be at least 3 characters long").show();
            txtName.requestFocus();
            return;
        }else if(!txtPrice.getText().matches("^[1-9][0-9]{1,9}$")){
            new Alert(Alert.AlertType.ERROR, "Invalid price").show();
            txtPrice.requestFocus();
            return;
        }
        if(btnAdd.getText().equalsIgnoreCase("ADD")){
            try {
                if(existHall(txtHallId.getText())){
                    new Alert(Alert.AlertType.ERROR, txtHallId.getText() + " already exists").show();
                }
                hallBO.saveHall(new HallDTO(txtHallId.getText(),txtName.getText(),role,Double.parseDouble(txtPrice.getText())));
                new Alert(Alert.AlertType.CONFIRMATION, "Save hall successfully").show();
                tblHall.getItems().add(new HallTM(txtHallId.getText(),txtName.getText(),role,Double.parseDouble(txtPrice.getText())));
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    boolean existHall(String id) throws SQLException, ClassNotFoundException {
        return hallBO.existsHall(id);
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
