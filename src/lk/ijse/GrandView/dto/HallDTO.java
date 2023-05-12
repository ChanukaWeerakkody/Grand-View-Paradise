package lk.ijse.GrandView.dto;

public class HallDTO {
    private String hallId;
    private String name;
    private String type;
    private double price;

    public HallDTO() {
    }

    public HallDTO(String hallId, String name, String type, double price) {
        this.hallId = hallId;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getHallId() {
        return hallId;
    }

    public void setHallId(String hallId) {
        this.hallId = hallId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
