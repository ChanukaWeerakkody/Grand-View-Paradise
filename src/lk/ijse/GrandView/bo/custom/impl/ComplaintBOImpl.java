package lk.ijse.GrandView.bo.custom.impl;

import lk.ijse.GrandView.bo.custom.ComplaintBO;
import lk.ijse.GrandView.dao.DAOFactory;
import lk.ijse.GrandView.dao.custom.ComplaintDAO;
import lk.ijse.GrandView.dto.ComplaintDTO;
import lk.ijse.GrandView.dto.EmployeeDTO;
import lk.ijse.GrandView.dto.GuestDTO;
import lk.ijse.GrandView.entity.Complaint;
import lk.ijse.GrandView.entity.Employee;
import lk.ijse.GrandView.entity.Guest;

import java.sql.SQLException;
import java.util.ArrayList;

public class ComplaintBOImpl implements ComplaintBO {
    private ComplaintDAO complaintDAO=(ComplaintDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.COMPLAINT);
    @Override
    public ArrayList<ComplaintDTO> getAllComplaint() throws SQLException, ClassNotFoundException {
        ArrayList<Complaint> all = complaintDAO.getAll();
        ArrayList<ComplaintDTO> allComplaints=new ArrayList<>();
        for (Complaint complaint : all) {
            allComplaints.add(new ComplaintDTO(complaint.getComID(), complaint.getGuestId(), complaint.getDesc(), complaint.getHallId(), complaint.getRoomId(), complaint.getDate()));
        }
        return allComplaints;
    }

    @Override
    public void saveComplaint(ComplaintDTO dto) throws SQLException, ClassNotFoundException {
        complaintDAO.save(new Complaint(dto.getComID(), dto.getGuestId(), dto.getDesc(), dto.getHallId(), dto.getRoomId(), dto.getDate()));
    }

    @Override
    public boolean existsComplaint(String id) throws SQLException, ClassNotFoundException {
        return complaintDAO.exist(id);
    }

    @Override
    public ComplaintDTO searchComplaint(String id) throws SQLException, ClassNotFoundException {
        Complaint ent = complaintDAO.search(id);
        return new ComplaintDTO(ent.getComID(), ent.getGuestId(), ent.getDesc(), ent.getHallId(), ent.getRoomId(), ent.getDate());
    }

    @Override
    public boolean deleteComplaint(String id) throws SQLException, ClassNotFoundException {
        return complaintDAO.delete(id);
    }

    @Override
    public void updateComplaint(ComplaintDTO dto) throws SQLException, ClassNotFoundException {
        complaintDAO.update(new Complaint(dto.getComID(), dto.getGuestId(), dto.getDesc(), dto.getHallId(), dto.getRoomId(), dto.getDate()));
    }

    @Override
    public int allComplaint() throws SQLException, ClassNotFoundException {
        return complaintDAO.checkActiveComplaint();
    }
}
