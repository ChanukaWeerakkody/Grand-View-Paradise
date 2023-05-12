package lk.ijse.GrandView.bo.custom.impl;

import lk.ijse.GrandView.bo.custom.UserBO;
import lk.ijse.GrandView.dao.DAOFactory;
import lk.ijse.GrandView.dao.custom.UserDAO;
import lk.ijse.GrandView.dto.UserDTO;
import lk.ijse.GrandView.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserBOImpl implements UserBO {
    private UserDAO userDAO=(UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);
    @Override
    public ArrayList<UserDTO> getAllUser() throws SQLException, ClassNotFoundException {
        ArrayList<User> all = userDAO.getAll();
        ArrayList<UserDTO>allUser=new ArrayList<>();
        for (User user : all) {
            allUser.add(new UserDTO(user.getEmpId(),user.getSystemRole(),user.getUsername(),user.getPassword()));
        }
        return allUser;
    }

    @Override
    public void saveUser(UserDTO dto) throws SQLException, ClassNotFoundException {
        userDAO.save(new User(dto.getEmpId(), dto.getSystemRole(), dto.getUsername(), dto.getPassword()));
    }

    @Override
    public boolean existsUser(String id) throws SQLException, ClassNotFoundException {
        return userDAO.exist(id);
    }

    @Override
    public UserDTO searchUser(String id) throws SQLException, ClassNotFoundException {
        User ent = userDAO.search(id);
        return new UserDTO(ent.getEmpId(), ent.getSystemRole(), ent.getUsername(), ent.getPassword());
    }

    @Override
    public boolean deleteUser(String id) throws SQLException, ClassNotFoundException {
        return userDAO.delete(id);
    }

    @Override
    public void updateUser(UserDTO dto) throws SQLException, ClassNotFoundException {
        userDAO.update(new User(dto.getEmpId(), dto.getSystemRole(), dto.getUsername(), dto.getPassword()));
    }

    @Override
    public String checkRank(String id) throws SQLException, ClassNotFoundException {
        return userDAO.checkRank(id);
    }

    @Override
    public String checkLogIn(String id) throws SQLException, ClassNotFoundException {
        return userDAO.checkLogIn(id);
    }

    @Override
    public UserDTO searchUsername(String id) throws SQLException, ClassNotFoundException {
        User ent = userDAO.searchUsername(id);
        return new UserDTO(ent.getEmpId(), ent.getSystemRole(), ent.getUsername(), ent.getPassword());
    }

    @Override
    public void changePassword(UserDTO dto) throws SQLException, ClassNotFoundException {
        userDAO.changePassword(new User(dto.getUsername(), dto.getPassword()));
    }
}
