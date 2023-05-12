package lk.ijse.GrandView.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import lk.ijse.GrandView.bo.BOFactory;
import lk.ijse.GrandView.bo.custom.impl.UserBOImpl;
import lk.ijse.GrandView.util.Navigation;
import lk.ijse.GrandView.util.Routes;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class LogInFormController {
    public JFXTextField txtUsername;
    public Hyperlink linkNewAccount;
    public Label lblTime;
    public Label lblDate;
    public AnchorPane mainPane;
    public JFXPasswordField txtPassword;
    private UserBOImpl userBO=(UserBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);

    public void initialize(){
        loadOrderTime();
        loadOrderDate();
    }

    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        String username=txtUsername.getText();
        try {
            if(txtUsername==null || txtPassword==null){
                txtUsername.setFocusColor(Paint.valueOf("red"));
                txtUsername.requestFocus();
                txtPassword.setFocusColor(Paint.valueOf("red"));
                txtPassword.requestFocus();
            }else {
                String role = userBO.checkRank(username);
                if(role==null){
                    txtUsername.setFocusColor(Paint.valueOf("red"));
                    txtUsername.requestFocus();
                }
                else if (role.equals("Admin")) {
                    String user = userBO.checkLogIn(username);
                    if (user == null) {
                        new Alert(Alert.AlertType.WARNING, "Invalid Username!").show();
                        txtUsername.setFocusColor(Paint.valueOf("red"));
                        txtUsername.requestFocus();
                    } else {
                        if (user.equals(txtPassword.getText())) {
                            Navigation.navigate(Routes.ADMIN_DASHBOARD, mainPane);
                        } else {
                            txtPassword.setFocusColor(Paint.valueOf("red"));
                            txtPassword.requestFocus();
                        }
                    }
                } else if (role.equals("User")) {
                    String userPassword = userBO.checkLogIn(username);
                    if (userPassword == null) {
                        new Alert(Alert.AlertType.WARNING, "Invalid Username!").show();
                        txtUsername.setFocusColor(Paint.valueOf("red"));
                        txtUsername.requestFocus();
                    } else {
                        if (userPassword.equals(txtPassword.getText())) {
                            Navigation.navigate(Routes.USER_DASHBOARD, mainPane);
                        } else {
                            txtPassword.setFocusColor(Paint.valueOf("red"));
                            txtPassword.requestFocus();
                        }
                    }
                } else {
                    txtPassword.setFocusColor(Paint.valueOf("red"));
                    txtPassword.requestFocus();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void linkNewAccountOnAction(ActionEvent actionEvent) throws IOException {
        String username=txtUsername.getText();
        try {
            String role =userBO.checkRank(username);
            if(role.equals("Admin")){
                Navigation.navigate(Routes.ADD_EMPLOYEE, mainPane);
            }else{
                new Alert(Alert.AlertType.WARNING,"Only Admin can!").show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadOrderTime(){
        lblTime.setText(String.valueOf(LocalDate.now()));
        DateFormat df = new SimpleDateFormat(" HH:mm:ss");
        Date dateobj = new Date();
        lblTime.setText(df.format(dateobj));
    }

    private void loadOrderDate() {
        lblDate.setText(String.valueOf(LocalDate.now()));
    }

    public void linkForgotPassword(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.FORGOT_PASSWORD, mainPane);
    }
}
