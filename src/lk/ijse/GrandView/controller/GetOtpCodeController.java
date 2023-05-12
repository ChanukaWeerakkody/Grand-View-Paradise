package lk.ijse.GrandView.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import lk.ijse.GrandView.bo.BOFactory;
import lk.ijse.GrandView.bo.custom.impl.UserBOImpl;
import lk.ijse.GrandView.util.Navigation;
import lk.ijse.GrandView.util.Routes;

import java.io.IOException;
import java.util.Random;

public class GetOtpCodeController {
    public AnchorPane mainPane;
    public JFXTextField txtOTP;
    public Label lblOtp;
    String systemOTP, userOTP, s = "";
    int ranNo;
    private UserBOImpl userBO=(UserBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);

    public void nextOnAction(ActionEvent actionEvent) throws IOException {
        userOTP = txtOTP.getText();
        if (systemOTP.equals(userOTP)) {
            Navigation.navigate(Routes.CHANGE_PASSWORD, mainPane);
        }else {
            new Alert(Alert.AlertType.ERROR, "Please enter valid OTP!").show();
        }
    }

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.FORGOT_PASSWORD, mainPane);
    }

    public void getOtpCodeOnAction(ActionEvent actionEvent) {
        getOTP(4);
    }
    public void getOTP(int len) {
        for (int i = 0; i < len; i++) {
            ranNo = new Random().nextInt(9);
            s = s.concat(Integer.toString(ranNo));
        }
        systemOTP = s;
        lblOtp.setText(s);
    }
}
