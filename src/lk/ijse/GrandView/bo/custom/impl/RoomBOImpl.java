package lk.ijse.GrandView.bo.custom.impl;

import lk.ijse.GrandView.bo.custom.RoomBO;
import lk.ijse.GrandView.dao.DAOFactory;
import lk.ijse.GrandView.dao.custom.RoomDAO;
import lk.ijse.GrandView.dto.RoomDTO;
import lk.ijse.GrandView.entity.Room;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoomBOImpl implements RoomBO {
    private RoomDAO roomDAO=(RoomDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ROOM);
    @Override
    public ArrayList<RoomDTO> getAllRoom() throws SQLException, ClassNotFoundException {
        ArrayList<Room> all = roomDAO.getAll();
        ArrayList<RoomDTO>allRoom=new ArrayList<>();
        for (Room room : all) {
            allRoom.add(new RoomDTO(room.getRoomId(),room.getStatus(),room.getType(),room.getPrice(),room.getHallId()));
        }
        return allRoom;
    }

    @Override
    public void saveRoom(RoomDTO dto) throws SQLException, ClassNotFoundException {
        roomDAO.save(new Room(dto.getRoomId(), dto.getStatus(), dto.getType(), dto.getPrice(),dto.getHallId()));
    }

    @Override
    public boolean existsRoom(String id) throws SQLException, ClassNotFoundException {
        return roomDAO.exist(id);
    }

    @Override
    public RoomDTO searchRoom(String id) throws SQLException, ClassNotFoundException {
        Room ent = roomDAO.search(id);
        return new RoomDTO(ent.getRoomId(), ent.getStatus(), ent.getType(), ent.getPrice(), ent.getHallId());
    }

    @Override
    public boolean deleteRoom(String id) throws SQLException, ClassNotFoundException {
        return roomDAO.delete(id);
    }

    @Override
    public void updateRoom(RoomDTO dto) throws SQLException, ClassNotFoundException {
        roomDAO.update(new Room(dto.getRoomId(), dto.getStatus(), dto.getType(), dto.getPrice(), dto.getHallId()));
    }

    @Override
    public int activeRooms() throws SQLException, ClassNotFoundException {
        return roomDAO.checkAvailableRooms();
    }

    @Override
    public int bookedRooms() throws SQLException, ClassNotFoundException {
        return roomDAO.checkBookedRooms();
    }

    @Override
    public int allRooms() throws SQLException, ClassNotFoundException {
        return roomDAO.activeRooms();
    }

    @Override
    public ArrayList<String> loadRoomId() throws SQLException, ClassNotFoundException {
        return roomDAO.loadRoomIds();
    }
}
