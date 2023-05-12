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
import lk.ijse.GrandView.bo.custom.impl.RoomBOImpl;
import lk.ijse.GrandView.dto.HallDTO;
import lk.ijse.GrandView.dto.RoomDTO;
import lk.ijse.GrandView.view.tdm.HallTM;
import lk.ijse.GrandView.view.tdm.RoomTM;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoomController {
    public AnchorPane subPane;
    public JFXComboBox cmbStatus;
    public JFXTextField txtRoomId;
    public JFXTextField txtPrice;
    public JFXTextField txtType;
    public JFXButton btnClear;
    public JFXButton btnAdd;
    public JFXButton btnUpdate;
    public JFXButton btnSearch;
    public JFXButton btnDelete;
    public TableView tblRooms;
    public TableColumn colRoomId;
    public TableColumn colStatus;
    public TableColumn colType;
    public TableColumn colPrice;
    public TableColumn colHallId;
    public Label lblTime;
    public JFXTextField txtHallId;
    private String [] roleList={"Available","Unavailable"};
    private RoomBOImpl roomBO=(RoomBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ROOM);

    public void initialize(){
        colRoomId.setCellValueFactory(new PropertyValueFactory<>("roomId"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colHallId.setCellValueFactory(new PropertyValueFactory<>("hallId"));
        try {
            setRoomInToTable();
            statusOnAction();
            loadOrderTime();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void setRoomInToTable() throws SQLException, ClassNotFoundException {
        tblRooms.getItems().clear();
        try {
            ArrayList<RoomDTO> allRoom=roomBO.getAllRoom();
            for(RoomDTO room: allRoom){
                tblRooms.getItems().add(new RoomTM(room.getRoomId(), room.getStatus(), room.getType(),room.getPrice(),room.getHallId()));
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
        txtRoomId.clear();
        txtType.clear();
        txtHallId.clear();
        txtPrice.clear();
    }

    public void addOnAction(ActionEvent actionEvent) {
        String role=(String) cmbStatus.getValue();
        if(!txtRoomId.getText().matches("^(R)[-]?[0-9]{3}$")) {
            new Alert(Alert.AlertType.ERROR, "Invalid id").show();
            txtHallId.requestFocus();
            return;
        }else if (!txtType.getText().matches("^[A-z ]{5,30}$")) {
            new Alert(Alert.AlertType.ERROR, "Name should be at least 3 characters long").show();
            txtType.requestFocus();
            return;
        }else if(!txtPrice.getText().matches("^[1-9][0-9]{1,9}$")){
            new Alert(Alert.AlertType.ERROR, "Invalid price").show();
            txtPrice.requestFocus();
            return;
        }
        if(btnAdd.getText().equalsIgnoreCase("ADD")){
            try {
                if(existRoom(txtRoomId.getText())){
                    new Alert(Alert.AlertType.ERROR, txtRoomId.getText() + " already exists").show();
                }
                roomBO.saveRoom(new RoomDTO(txtRoomId.getText(),role,txtType.getText(),Double.parseDouble(txtPrice.getText()),txtHallId.getText()));
                new Alert(Alert.AlertType.CONFIRMATION, "Save room successfully").show();
                tblRooms.getItems().add(new RoomDTO(txtRoomId.getText(),role,txtType.getText(),Double.parseDouble(txtPrice.getText()),txtHallId.getText()));
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    boolean existRoom(String id) throws SQLException, ClassNotFoundException {
        return roomBO.existsRoom(id);
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
