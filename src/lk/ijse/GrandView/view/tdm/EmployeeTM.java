package lk.ijse.GrandView.view.tdm;

public class EmployeeTM {
    private String id;
    private String name;
    private String address;
    private int contact;

    public EmployeeTM() {
    }

    public EmployeeTM(String id, String name, String address, int contact) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
