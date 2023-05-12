package lk.ijse.GrandView.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.GrandView.bo.BOFactory;
import lk.ijse.GrandView.bo.custom.impl.ComplaintBOImpl;
import lk.ijse.GrandView.bo.custom.impl.HallBOImpl;
import lk.ijse.GrandView.bo.custom.impl.RoomBOImpl;
import lk.ijse.GrandView.util.Navigation;
import lk.ijse.GrandView.util.Routes;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

public class UserDashBoardController {
    public AnchorPane mainPane;
    public AnchorPane barPane;
    public AnchorPane subPane;
    public Label lblTotalRooms;
    public Label lblAvailableRooms;
    public Label lblBookedRooms;
    public Label lblBookedHalls;
    public Label lblAvailableHalls;
    public Label lblComplaint;
    public Label lblTime;
    private RoomBOImpl roomBO=(RoomBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ROOM);
    private HallBOImpl hallBO=(HallBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.HALL);
    private ComplaintBOImpl complaintBO=(ComplaintBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.COMPLAINT);

    public void initialize(){
        loadOrderTime();
        displayAvailableRooms();
        displayAllRooms();
        displayUnavailableRooms();
        displayUnavailableHalls();
        displayAvailableHalls();
        displayComplaints();
    }
    public void logOutOnAction(MouseEvent mouseEvent) {
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure want to logOut?");
        Optional<ButtonType> option=alert.showAndWait();

        if(option.get().equals(ButtonType.OK)){
            try {
                Navigation.navigate(Routes.LOG,mainPane);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else return;
    }

    public void dashBoardOnAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.USER_DASHBOARD,mainPane);
    }

    public void mealsOnAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.MEAL_DETAIL,subPane);
    }

    public void paymentOnAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.PAYMENT,subPane);
    }

    public void guestOnAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.GUEST,subPane);
    }

    public void complaintOnAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.COMPLAINT,subPane);
    }

    public void btnAboutUsOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ABOUT_US,subPane);
    }

    public void btnContactOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.CONTACT,subPane);
    }
    private void loadOrderTime(){
        lblTime.setText(String.valueOf(LocalDate.now()));
        DateFormat df = new SimpleDateFormat(" HH:mm:ss");
        Date dateobj = new Date();
        lblTime.setText(df.format(dateobj));
    }
    public void displayAvailableRooms(){
        int count=0;
        try {
            count = roomBO.activeRooms();
            if(count != 0) {
                lblAvailableRooms.setText(String.valueOf(count));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void displayAllRooms(){
        int count=0;
        try {
            count = roomBO.allRooms();
            if(count != 0) {
                lblTotalRooms.setText(String.valueOf(count));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void displayUnavailableRooms(){
        int count=0;
        try {
            count = roomBO.bookedRooms();
            if(count != 0) {
                lblBookedRooms.setText(String.valueOf(count));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void displayUnavailableHalls(){
        int count=0;
        try {
            count = hallBO.bookedHalls();
            if(count != 0) {
                lblBookedHalls.setText(String.valueOf(count));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void displayAvailableHalls(){
        int count=0;
        try {
            count = hallBO.activeHalls();
            if(count != 0) {
                lblAvailableHalls.setText(String.valueOf(count));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void displayComplaints(){
        int count=0;
        try {
            count = complaintBO.allComplaint();
            if(count != 0) {
                lblComplaint.setText(String.valueOf(count));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void roomsOnAction(MouseEvent mouseEvent) {
    }
}
