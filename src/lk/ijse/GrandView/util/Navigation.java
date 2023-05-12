package lk.ijse.GrandView.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {
    private static AnchorPane pane;

    public static void navigate(Routes route, AnchorPane pane) throws IOException {
        Navigation.pane = pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage) Navigation.pane.getScene().getWindow();
        switch (route){
            case LOG:
                window.setTitle("Log iN");
                initUI("LogInForm.fxml");
                break;
            case ADMIN_DASHBOARD:
                window.setTitle("DashBoard");
                initUI("AdminDashBoard.fxml");
                break;
            case EMPLOYEE:
                window.setTitle("Employee");
                initUI("Employee.fxml");
                break;
            case USER:
                window.setTitle("User");
                initUI("User.fxml");
                break;
            case HALL:
                window.setTitle("Hall");
                initUI("Hall.fxml");
                break;
            case ROOM:
                window.setTitle("Room");
                initUI("Room.fxml");
                break;
            case MEAL:
                window.setTitle("Meal");
                initUI("Meal.fxml");
                break;
            case ABOUT_US:
                window.setTitle("About Us");
                initUI("AboutUs.fxml");
                break;
            case CONTACT:
                window.setTitle("Contact Us");
                initUI("ContactUs.fxml");
                break;
            case FORGOT_PASSWORD:
                window.setTitle("Forgot Password");
                initUI("ForgotPassword.fxml");
                break;
            case GET_OTP:
                window.setTitle("Forgot Password");
                initUI("GetOtpCode.fxml");
                break;
            case CHANGE_PASSWORD:
                window.setTitle("Forgot Password");
                initUI("ChangePassword.fxml");
                break;
            case ADD_EMPLOYEE:
                window.setTitle("Forgot Password");
                initUI("AddEmployee.fxml");
                break;
            case USER_DASHBOARD:
                window.setTitle("User Dashboard");
                initUI("UserDashBoard.fxml");
                break;
            case COMPLAINT:
                window.setTitle("Complaint");
                initUI("Complaint.fxml");
                break;
            case GUEST:
                window.setTitle("Guest");
                initUI("Guest.fxml");
                break;
            case MEAL_DETAIL:
                window.setTitle("Meal");
                initUI("MealDetail.fxml");
                break;
            case PAYMENT:
                window.setTitle("Payment");
                initUI("Payment.fxml");
                break;
            default:
                new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public static void initUI(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class.getResource("/lk/ijse/GrandView/view/" + location)));
    }
}
