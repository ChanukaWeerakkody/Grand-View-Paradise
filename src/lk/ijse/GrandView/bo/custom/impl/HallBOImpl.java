package lk.ijse.GrandView.bo.custom.impl;

import lk.ijse.GrandView.bo.custom.HallBO;
import lk.ijse.GrandView.dao.DAOFactory;
import lk.ijse.GrandView.dao.custom.HallDAO;
import lk.ijse.GrandView.dto.HallDTO;
import lk.ijse.GrandView.entity.Hall;
import java.sql.SQLException;
import java.util.ArrayList;

public class HallBOImpl implements HallBO {
    private HallDAO hallDAO=(HallDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.HALL);
    @Override
    public ArrayList<HallDTO> getAllHall() throws SQLException, ClassNotFoundException {
        ArrayList<Hall> all = hallDAO.getAll();
        ArrayList<HallDTO> allHall = new ArrayList<>();
        for (Hall hall : all) {
            allHall.add(new HallDTO(hall.getHallId(), hall.getName(), hall.getType(), hall.getPrice()));
        }
        return allHall;
    }

    @Override
    public void saveHall(HallDTO dto) throws SQLException, ClassNotFoundException {
        hallDAO.save(new Hall(dto.getHallId(), dto.getName(), dto.getType(), dto.getPrice()));
    }

    @Override
    public boolean existsHall(String id) throws SQLException, ClassNotFoundException {
        return hallDAO.exist(id);
    }

    @Override
    public HallDTO searchHall(String id) throws SQLException, ClassNotFoundException {
        Hall ent = hallDAO.search(id);
        return new HallDTO(ent.getHallId(), ent.getName(), ent.getType(), ent.getPrice());
    }

    @Override
    public boolean deleteHall(String id) throws SQLException, ClassNotFoundException {
        return hallDAO.delete(id);
    }

    @Override
    public void updateHall(HallDTO dto) throws SQLException, ClassNotFoundException {
        hallDAO.update(new Hall(dto.getHallId(), dto.getName(), dto.getType(), dto.getPrice()));
    }

    @Override
    public int activeHalls() throws SQLException, ClassNotFoundException {
        return hallDAO.checkAvailableHalls();
    }

    @Override
    public int bookedHalls() throws SQLException, ClassNotFoundException {
        return hallDAO.checkBookedHalls();
    }

    @Override
    public ArrayList<String> loadHallId() throws SQLException, ClassNotFoundException {
        return hallDAO.loadHallIds();
    }
}
