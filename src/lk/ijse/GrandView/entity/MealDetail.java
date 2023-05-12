package lk.ijse.GrandView.entity;

public class MealDetail {
    private String orderId;
    private String mealId;
    private String guestId;
    private String desc;
    private int qty;
    private double price;

    public MealDetail() {
    }

    public MealDetail(String orderId, String mealId, String guestId, String desc, int qty, double price) {
        this.orderId = orderId;
        this.mealId = mealId;
        this.guestId = guestId;
        this.desc = desc;
        this.qty = qty;
        this.price = price;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getMealId() {
        return mealId;
    }

    public void setMealId(String mealId) {
        this.mealId = mealId;
    }

    public String getGuestId() {
        return guestId;
    }

    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
