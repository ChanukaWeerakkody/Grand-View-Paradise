package lk.ijse.GrandView.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import lk.ijse.GrandView.bo.BOFactory;
import lk.ijse.GrandView.bo.custom.impl.UserBOImpl;
import lk.ijse.GrandView.dto.UserDTO;
import lk.ijse.GrandView.util.Navigation;
import lk.ijse.GrandView.util.Routes;

import java.io.IOException;
import java.sql.SQLException;

public class ForgotPasswordController {
    public JFXTextField txtUsername;
    public AnchorPane mainPane;
    private UserBOImpl userBO=(UserBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);

    public void nextOnAction(ActionEvent actionEvent) {
        String username=txtUsername.getText();
        try {
            UserDTO userDTO = userBO.searchUsername(username);
            if(userDTO!=null){
                Navigation.navigate(Routes.GET_OTP, mainPane);
            }else{
                new Alert(Alert.AlertType.WARNING, "User Not Found!").show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOG, mainPane);
    }
}
