package lk.ijse.GrandView.bo.custom;

import lk.ijse.GrandView.bo.SuperBO;
import lk.ijse.GrandView.dto.RoomDetailsDTO;
import java.sql.SQLException;
import java.util.ArrayList;

public interface RoomDetailBO extends SuperBO {
    ArrayList<RoomDetailsDTO> getAllRoomDetail() throws SQLException, ClassNotFoundException;
    void saveRoomDetail(RoomDetailsDTO dto) throws SQLException, ClassNotFoundException;
    boolean existsRoomDetail(String id) throws SQLException, ClassNotFoundException;
    RoomDetailsDTO searchRoomDetail(String id) throws SQLException, ClassNotFoundException;
    boolean deleteRoomDetail(String id) throws SQLException, ClassNotFoundException;
    void updateRoomDetail(RoomDetailsDTO dto) throws SQLException, ClassNotFoundException;
}
