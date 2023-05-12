package lk.ijse.GrandView.bo.custom;

import lk.ijse.GrandView.bo.SuperBO;
import lk.ijse.GrandView.dto.HallDTO;
import java.sql.SQLException;
import java.util.ArrayList;

public interface HallBO extends SuperBO {
    ArrayList<HallDTO> getAllHall() throws SQLException, ClassNotFoundException;
    void saveHall(HallDTO dto) throws SQLException, ClassNotFoundException;
    boolean existsHall(String id) throws SQLException, ClassNotFoundException;
    HallDTO searchHall(String id) throws SQLException, ClassNotFoundException;
    boolean deleteHall(String id) throws SQLException, ClassNotFoundException;
    void updateHall(HallDTO dto) throws SQLException, ClassNotFoundException;
    int activeHalls() throws SQLException, ClassNotFoundException;
    int bookedHalls() throws SQLException, ClassNotFoundException;
    ArrayList<String> loadHallId() throws SQLException, ClassNotFoundException;
}
