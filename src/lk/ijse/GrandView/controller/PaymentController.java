package lk.ijse.GrandView.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class PaymentController {
    public AnchorPane subPane;
    public Label lblTotalPrice;
    public Label lblPaymentId;
    public Label lblMealCharges;
    public Label lblRoomCharges;
    public JFXTextField txtGuestId;
    public JFXButton btnPlaceOrder;
    public Label lblTime;
    public JFXTextField txtPayment;
    public Label lblBilledDate;
    public Label lblBalance;

    public void printOnAction(ActionEvent actionEvent) {
    }

    public void placeOrderOnAction(ActionEvent actionEvent) {
    }
}
