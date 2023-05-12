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
import lk.ijse.GrandView.bo.custom.impl.ComplaintBOImpl;
import lk.ijse.GrandView.bo.custom.impl.GuestBOImpl;
import lk.ijse.GrandView.bo.custom.impl.HallBOImpl;
import lk.ijse.GrandView.bo.custom.impl.RoomBOImpl;
import lk.ijse.GrandView.dto.ComplaintDTO;
import lk.ijse.GrandView.dto.GuestDTO;
import lk.ijse.GrandView.util.Navigation;
import lk.ijse.GrandView.util.Routes;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class ComplaintController {
    public AnchorPane subPane;
    public JFXComboBox cmbGuest;
    public Label lblDate;
    public JFXTextField txtId;
    public JFXTextField txtDesc;
    public JFXButton btnAdd;
    public Label lblTime;
    public JFXComboBox cmbHallId;
    public JFXComboBox cmbRoom;
    private GuestBOImpl guestBO=(GuestBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.GUEST);
    private ComplaintBOImpl complaintBO=(ComplaintBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.COMPLAINT);
    private RoomBOImpl roomBO=(RoomBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ROOM);
    private HallBOImpl hallBO=(HallBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.HALL);

    public void initialize(){
        loadOrderDate();
        loadGuestIds();
        loadHallIds();
        loadRoomIds();
        loadOrderTime();
    }
    private void loadGuestIds() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> idList = guestBO.loadGuestId();
            for (String id : idList) {
                observableList.add(id);
            }
            cmbGuest.setItems(observableList);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private void loadRoomIds() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> idList = roomBO.loadRoomId();
            for (String id : idList) {
                observableList.add(id);
            }
            cmbRoom.setItems(observableList);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private void loadHallIds() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> idList = hallBO.loadHallId();
            for (String id : idList) {
                observableList.add(id);
            }
            cmbHallId.setItems(observableList);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public void clearOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.COMPLAINT,subPane);
    }
    private void loadOrderDate() {
        lblDate.setText(String.valueOf(LocalDate.now()));
    }

    public void addOnAction(ActionEvent actionEvent) {
        String cmId=txtId.getText();
        String guestId=String.valueOf(cmbGuest.getValue());
        String desc=txtDesc.getText();
        String hallId=String.valueOf(cmbHallId.getValue());
        String roomId=String.valueOf(cmbRoom.getValue());
        String date=lblDate.getText();

        if(!txtId.getText().matches("^(C)[-]?[0-9]{3}$")) {
            new Alert(Alert.AlertType.ERROR, "Invalid id").show();
            txtId.requestFocus();
            return;
        }else if(!txtDesc.getText().matches("^[A-z ]{5,30}$")) {
            new Alert(Alert.AlertType.ERROR, "Invalid name").show();
            txtDesc.requestFocus();
            return;
        }
        if(btnAdd.getText().equalsIgnoreCase("ADD")){
            try {
                if(existComplaint(cmId)){
                    new Alert(Alert.AlertType.ERROR, cmId + " already exists").show();
                }
                complaintBO.saveComplaint(new ComplaintDTO(cmId,guestId,desc,hallId,roomId,date));
                new Alert(Alert.AlertType.CONFIRMATION, "Save complaint successfully").show();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    boolean existComplaint(String id) throws SQLException, ClassNotFoundException {
        return complaintBO.existsComplaint(id);
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
