package lk.ijse.GrandView.controller;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class AboutUsController {
    public AnchorPane subPane;
    public Label lblTime;

    public void initialize(){
        loadOrderTime();
    }
    private void loadOrderTime(){
        lblTime.setText(String.valueOf(LocalDate.now()));
        DateFormat df = new SimpleDateFormat(" HH:mm:ss");
        Date dateobj = new Date();
        lblTime.setText(df.format(dateobj));
    }
}
