package common.dao;

import common.entities.Users;

/**
 * интерфейс дао пользователей для работы с бд
 */
public interface UsersDao {
    boolean addUser(Users user) throws ClassNotFoundException;

    boolean checkUser(Users user) throws ClassNotFoundException;

}
