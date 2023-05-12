package lk.ijse.GrandView.bo.custom;

import lk.ijse.GrandView.bo.SuperBO;
import lk.ijse.GrandView.dto.GuestDTO;
import java.sql.SQLException;
import java.util.ArrayList;

public interface GuestBO extends SuperBO {
    ArrayList<GuestDTO> getAllGuest() throws SQLException, ClassNotFoundException;
    void saveGuest(GuestDTO dto) throws SQLException, ClassNotFoundException;
    boolean existsGuest(String id) throws SQLException, ClassNotFoundException;
    GuestDTO searchGuest(String id) throws SQLException, ClassNotFoundException;
    boolean deleteGuest(String id) throws SQLException, ClassNotFoundException;
    void updateGuest(GuestDTO dto) throws SQLException, ClassNotFoundException;
    ArrayList<String> loadGuestId() throws SQLException, ClassNotFoundException;
}
