package com.service;

import com.DAO.UserDao;
import com.beans.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    public static List<User> getAllUsers(){
        try {
            List<User> users = UserDao.getAllUser();
            if(users != null) return users;
            else return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
