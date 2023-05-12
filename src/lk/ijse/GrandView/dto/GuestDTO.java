package lk.ijse.GrandView.dto;

public class GuestDTO {
    private String guestId;
    private String name;
    private String address;
    private int contact;

    public GuestDTO() {
    }

    public GuestDTO(String guestId, String name, String address, int contact) {
        this.guestId = guestId;
        this.name = name;
        this.address = address;
        this.contact = contact;
    }

    public String getGuestId() {
        return guestId;
    }

    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }
}
