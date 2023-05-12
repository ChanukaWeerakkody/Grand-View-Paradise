package lk.ijse.GrandView.dto;

public class RoomDetailsDTO {
    private String resId;
    private String guestId;
    private String hallId;
    private String roomId;
    private String inDate;
    private String outDate;
    private double price;

    public RoomDetailsDTO() {
    }

    public RoomDetailsDTO(String resId, String guestId, String hallId, String roomId, String inDate, String outDate, double price) {
        this.resId = resId;
        this.guestId = guestId;
        this.hallId = hallId;
        this.roomId = roomId;
        this.inDate = inDate;
        this.outDate = outDate;
        this.price = price;
    }

    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId;
    }

    public String getGuestId() {
        return guestId;
    }

    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }

    public String getHallId() {
        return hallId;
    }

    public void setHallId(String hallId) {
        this.hallId = hallId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getInDate() {
        return inDate;
    }

    public void setInDate(String inDate) {
        this.inDate = inDate;
    }

    public String getOutDate() {
        return outDate;
    }

    public void setOutDate(String outDate) {
        this.outDate = outDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
