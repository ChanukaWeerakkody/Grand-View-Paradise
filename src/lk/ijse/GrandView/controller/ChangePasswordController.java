package lk.ijse.GrandView.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import lk.ijse.GrandView.bo.BOFactory;
import lk.ijse.GrandView.bo.custom.impl.UserBOImpl;
import lk.ijse.GrandView.dto.UserDTO;
import lk.ijse.GrandView.util.Navigation;
import lk.ijse.GrandView.util.Routes;
import java.io.IOException;
import java.sql.SQLException;

public class ChangePasswordController {
    public AnchorPane mainPane;
    public JFXTextField txtUsername;
    public Label lblOtp;
    public JFXPasswordField txtPassword;
    private UserBOImpl userBO=(UserBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);

    public void saveOnAction(ActionEvent actionEvent){
        try {
            if(!txtPassword.getText().matches("^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$")){
                new Alert(Alert.AlertType.ERROR, "Invalid Password").show();
                txtPassword.requestFocus();
                return;
            }
            userBO.changePassword(new UserDTO(txtUsername.getText(),txtPassword.getText()));
            new Alert(Alert.AlertType.INFORMATION, "Password Changed Successfully").show();
        } catch (SQLException e) {
            new Alert(Alert.AlertType.WARNING, "Password Changed Unsuccessfully !").show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOG, mainPane);
    }
}
