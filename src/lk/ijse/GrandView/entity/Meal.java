package lk.ijse.GrandView.entity;

public class Meal {
    private String mealID;
    private String type;
    private String desc;
    private double price;

    public Meal() {
    }

    public Meal(String mealID, String type, String desc, double price) {
        this.mealID = mealID;
        this.type = type;
        this.desc = desc;
        this.price = price;
    }

    public Meal(String mealID, String desc, double price) {
        this.mealID = mealID;
        this.desc = desc;
        this.price = price;
    }

    public String getMealID() {
        return mealID;
    }

    public void setMealID(String mealID) {
        this.mealID = mealID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
