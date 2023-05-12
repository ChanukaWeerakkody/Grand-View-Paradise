package lk.ijse.GrandView.entity;

public class Complaint {
    private String comID;
    private String guestId;
    private String desc;
    private String hallId;
    private String roomId;
    private String date;

    public Complaint() {
    }

    public Complaint(String comID, String guestId, String desc, String hallId, String roomId, String date) {
        this.comID = comID;
        this.guestId = guestId;
        this.desc = desc;
        this.hallId = hallId;
        this.roomId = roomId;
        this.date = date;
    }

    public String getComID() {
        return comID;
    }

    public void setComID(String comID) {
        this.comID = comID;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
