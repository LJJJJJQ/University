package com.service;

import com.DAO.UserDao;

import java.sql.SQLException;

public class RegisterService {
    public static boolean register(String name, String psw){
        try {
            int f = UserDao.insert(name,psw);
            if(f != 0){
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
