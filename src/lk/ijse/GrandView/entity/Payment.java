package lk.ijse.GrandView.entity;

public class Payment {
    private String paymentId;
    private String guestId;
    private String mealId;
    private String roomId;
    private double total;
    private String date;
    private double payment;
    private double balance;

    public Payment() {
    }

    public Payment(String paymentId, String guestId, String mealId, String roomId, double total, String date, double payment, double balance) {
        this.paymentId = paymentId;
        this.guestId = guestId;
        this.mealId = mealId;
        this.roomId = roomId;
        this.total = total;
        this.date = date;
        this.payment = payment;
        this.balance = balance;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getGuestId() {
        return guestId;
    }

    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }

    public String getMealId() {
        return mealId;
    }

    public void setMealId(String mealId) {
        this.mealId = mealId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
