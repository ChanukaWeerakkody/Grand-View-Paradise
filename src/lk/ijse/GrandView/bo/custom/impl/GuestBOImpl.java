package lk.ijse.GrandView.bo.custom.impl;

import lk.ijse.GrandView.bo.custom.GuestBO;
import lk.ijse.GrandView.dao.DAOFactory;
import lk.ijse.GrandView.dao.custom.GuestDAO;
import lk.ijse.GrandView.dto.GuestDTO;
import lk.ijse.GrandView.entity.Guest;
import java.sql.SQLException;
import java.util.ArrayList;

public class GuestBOImpl implements GuestBO {
    private GuestDAO guestDAO=(GuestDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.GUEST);
    @Override
    public ArrayList<GuestDTO> getAllGuest() throws SQLException, ClassNotFoundException {
        ArrayList<Guest> all = guestDAO.getAll();
        ArrayList<GuestDTO> allGuests=new ArrayList<>();
        for (Guest guest : all) {
            allGuests.add(new GuestDTO(guest.getGuestId(), guest.getName(), guest.getAddress(), guest.getContact()));
        }
        return allGuests;
    }

    @Override
    public void saveGuest(GuestDTO dto) throws SQLException, ClassNotFoundException {
        guestDAO.save(new Guest(dto.getGuestId(), dto.getName(), dto.getAddress(), dto.getContact()));
    }

    @Override
    public boolean existsGuest(String id) throws SQLException, ClassNotFoundException {
        return guestDAO.exist(id);
    }

    @Override
    public GuestDTO searchGuest(String id) throws SQLException, ClassNotFoundException {
        Guest ent = guestDAO.search(id);
        return new GuestDTO(ent.getGuestId(), ent.getName(), ent.getAddress(), ent.getContact());
    }

    @Override
    public boolean deleteGuest(String id) throws SQLException, ClassNotFoundException {
        return guestDAO.delete(id);
    }

    @Override
    public void updateGuest(GuestDTO dto) throws SQLException, ClassNotFoundException {
        guestDAO.update(new Guest(dto.getGuestId(), dto.getName(), dto.getAddress(), dto.getContact()));
    }

    @Override
    public ArrayList<String> loadGuestId() throws SQLException, ClassNotFoundException {
        return guestDAO.loadGuestIds();
    }
}
