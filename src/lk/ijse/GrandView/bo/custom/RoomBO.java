package lk.ijse.GrandView.bo.custom;

import lk.ijse.GrandView.bo.SuperBO;
import lk.ijse.GrandView.dto.EmployeeDTO;
import lk.ijse.GrandView.dto.RoomDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RoomBO extends SuperBO {
    ArrayList<RoomDTO> getAllRoom() throws SQLException, ClassNotFoundException;
    void saveRoom(RoomDTO dto) throws SQLException, ClassNotFoundException;
    boolean existsRoom(String id) throws SQLException, ClassNotFoundException;
    RoomDTO searchRoom(String id) throws SQLException, ClassNotFoundException;
    boolean deleteRoom(String id) throws SQLException, ClassNotFoundException;
    void updateRoom(RoomDTO dto) throws SQLException, ClassNotFoundException;
    int activeRooms() throws SQLException, ClassNotFoundException;
    int bookedRooms() throws SQLException, ClassNotFoundException;
    int allRooms() throws SQLException, ClassNotFoundException;
    ArrayList<String> loadRoomId() throws SQLException, ClassNotFoundException;
}
