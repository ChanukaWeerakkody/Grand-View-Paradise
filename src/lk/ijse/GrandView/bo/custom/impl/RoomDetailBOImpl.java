package lk.ijse.GrandView.bo.custom.impl;

import lk.ijse.GrandView.bo.custom.RoomDetailBO;
import lk.ijse.GrandView.dao.DAOFactory;
import lk.ijse.GrandView.dao.custom.RoomDetailDAO;
import lk.ijse.GrandView.dto.RoomDetailsDTO;
import lk.ijse.GrandView.entity.RoomDetails;

import java.sql.SQLException;
import java.util.ArrayList;

public class RoomDetailBOImpl implements RoomDetailBO {
    private RoomDetailDAO roomDetailDAO=(RoomDetailDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ROOM_DETAIL);
    @Override
    public ArrayList<RoomDetailsDTO> getAllRoomDetail() throws SQLException, ClassNotFoundException {
        ArrayList<RoomDetails> all = roomDetailDAO.getAll();
        ArrayList<RoomDetailsDTO> allRooms = new ArrayList<>();
        for (RoomDetails roomDetails : all) {
            allRooms.add(new RoomDetailsDTO(roomDetails.getResId(), roomDetails.getGuestId(), roomDetails.getHallId(), roomDetails.getRoomId(),roomDetails.getInDate(),roomDetails.getOutDate(),roomDetails.getPrice()));
        }
        return allRooms;
    }

    @Override
    public void saveRoomDetail(RoomDetailsDTO dto) throws SQLException, ClassNotFoundException {
        roomDetailDAO.save(new RoomDetails(dto.getResId(), dto.getGuestId(), dto.getHallId(), dto.getRoomId(),dto.getInDate(),dto.getOutDate(),dto.getPrice()));
    }

    @Override
    public boolean existsRoomDetail(String id) throws SQLException, ClassNotFoundException {
        return roomDetailDAO.exist(id);
    }

    @Override
    public RoomDetailsDTO searchRoomDetail(String id) throws SQLException, ClassNotFoundException {
        RoomDetails ent = roomDetailDAO.search(id);
        return new RoomDetailsDTO(ent.getResId(), ent.getGuestId(), ent.getHallId(), ent.getRoomId(), ent.getInDate(), ent.getOutDate(), ent.getPrice());
    }

    @Override
    public boolean deleteRoomDetail(String id) throws SQLException, ClassNotFoundException {
        return roomDetailDAO.delete(id);
    }

    @Override
    public void updateRoomDetail(RoomDetailsDTO dto) throws SQLException, ClassNotFoundException {
        roomDetailDAO.update(new RoomDetails(dto.getResId(), dto.getGuestId(), dto.getHallId(), dto.getRoomId(),dto.getInDate(),dto.getOutDate(),dto.getPrice()));
    }
}
