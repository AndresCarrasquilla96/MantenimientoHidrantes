package models.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.User;
import utils.DbProperties;

public class UserDao {

    public UserDao() {
        try {
            dbProperties = new DbProperties();
            Class.forName(dbProperties.getDbDriver()).newInstance();
        } catch (ClassNotFoundException
                | InstantiationException
                | IllegalAccessException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public User getUserByUsernameAndPassword(String username, String password) {
        User user = null;
        try (Connection connection = DriverManager.getConnection(
                dbProperties.getDbDatasource(),
                dbProperties.getDbUser(),
                dbProperties.getDbPassword());
                PreparedStatement ps = connection.prepareStatement(GET_USER_BY_USERNAME_AND_PASSWORD);) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                user = UserDao.getUser(resultSet);
            }
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    public static User getUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setUsername(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        return user;
    }

    private static final String GET_USER_BY_USERNAME_AND_PASSWORD
            = "SELECT username, password "
            + "FROM usuario WHERE username = ? AND password = ?;";
    DbProperties dbProperties;
}
