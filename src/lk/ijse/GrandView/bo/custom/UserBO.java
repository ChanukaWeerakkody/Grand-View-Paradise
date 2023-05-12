package lk.ijse.GrandView.bo.custom;

import lk.ijse.GrandView.bo.SuperBO;
import lk.ijse.GrandView.dto.UserDTO;
import lk.ijse.GrandView.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserBO extends SuperBO {
    ArrayList<UserDTO> getAllUser() throws SQLException, ClassNotFoundException;
    void saveUser(UserDTO dto) throws SQLException, ClassNotFoundException;
    boolean existsUser(String id) throws SQLException, ClassNotFoundException;
    UserDTO searchUser(String id) throws SQLException, ClassNotFoundException;
    boolean deleteUser(String id) throws SQLException, ClassNotFoundException;
    void updateUser(UserDTO dto) throws SQLException, ClassNotFoundException;
    String checkRank(String id) throws SQLException, ClassNotFoundException;
    String checkLogIn(String id) throws SQLException, ClassNotFoundException;
    UserDTO searchUsername(String id) throws SQLException, ClassNotFoundException;
    void changePassword(UserDTO dto) throws SQLException, ClassNotFoundException;
}
