package lk.ijse.GrandView.entity;

public class Room {
    private String roomId;
    private String status;
    private String type;
    private double price;
    private String hallId;

    public Room() {
    }

    public Room(String roomId, String status, String type, double price, String hallId) {
        this.roomId = roomId;
        this.status = status;
        this.type = type;
        this.price = price;
        this.hallId = hallId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getHallId() {
        return hallId;
    }

    public void setHallId(String hallId) {
        this.hallId = hallId;
    }
}
