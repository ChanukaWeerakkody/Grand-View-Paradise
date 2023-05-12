package lk.ijse.GrandView.dao.custom;

import lk.ijse.GrandView.dao.CrudDAO;
import lk.ijse.GrandView.entity.User;

import java.sql.SQLException;

public interface UserDAO extends CrudDAO<User,String> {
    String checkLogIn(String username) throws SQLException, ClassNotFoundException;
    String checkRank(String username) throws SQLException, ClassNotFoundException;
    User searchUsername(String id) throws SQLException, ClassNotFoundException;
    boolean changePassword(User user) throws SQLException, ClassNotFoundException;
}
