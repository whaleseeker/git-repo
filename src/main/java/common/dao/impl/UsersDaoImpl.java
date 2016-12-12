package common.dao.impl;

import common.dao.UsersDao;
import common.entities.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * дао пользователей для работы с бд
 */
public class UsersDaoImpl implements UsersDao {
    private static final String URL = "jdbc:mysql://localhost:3306/mysite";
    private static final String USER = "root";
    private static final String PWD = "root";
    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    private static Logger logger = LoggerFactory.getLogger(UsersDaoImpl.class);

    public boolean addUser(Users user) throws ClassNotFoundException {
        Class.forName(DRIVER_NAME);
        try (Connection connection = DriverManager.getConnection(URL, USER, PWD);
             PreparedStatement ps = connection.prepareStatement("insert into users(name,lname,password,email) values(?,?,?,?)")) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getLname());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getEmail());
            if (ps.executeUpdate() > 0) {
                logger.info("You are successfully registered...");
                return true;
            }
        } catch (SQLException e) {
            logger.warn(e.getMessage());
        }
        return false;
    }


    @Override
    public boolean checkUser(Users user) throws ClassNotFoundException {
        Class.forName(DRIVER_NAME);
        try (Connection connection = DriverManager.getConnection(URL, USER, PWD);
             PreparedStatement ps = connection.prepareStatement("select * from users where email=? and password=?")) {
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                logger.info(user.getEmail() + " user authenticated");
                return true;
            }
            rs.close();
        } catch (Exception e) {
            logger.warn(e.getMessage());
            e.printStackTrace();
        }
        return false;
    }


}
