package com.DAO;
import com.beans.User;
import com.tuils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public static int insert(String name, String psw) throws SQLException{
        Connection connection = DBUtil.getDs().getConnection();
        PreparedStatement st = null;
       try {
           st = connection.prepareStatement("insert into user(username,password) values (?,?)");
           st.setString(1,name);
           st.setString(2,psw);
           int res = st.executeUpdate();
           return res;
       } catch (SQLException s){
           s.printStackTrace();
       } finally {
           if(st != null) st.close();
           if(connection != null) connection.close();
       }
       return -1;
    }

    public static boolean login(String name, String psw) throws SQLException{
        Connection connection = DBUtil.getDs().getConnection();
        PreparedStatement st = null;
        ResultSet resultSet = null;
        try{
            st = connection.prepareStatement("select count(1) from user where username=? and password= ?");
            st.setString(1,name);
            st.setString(2,psw);
            resultSet = st.executeQuery();
            resultSet.next();
            return resultSet.getInt(1) > 0;
        } catch (SQLException s){
            s.printStackTrace();
        } finally {
            if(resultSet != null) resultSet.close();
            if(st != null) st.close();
            if(connection != null) connection.close();
        }
        return false;
    }

    public static List<User> getAllUser() throws SQLException {
        Connection connection = DBUtil.getDs().getConnection();
        PreparedStatement st = null;
        ResultSet resultSet = null;
        try{
            st = connection.prepareStatement("select  * from user");
            resultSet = st.executeQuery();
            List<User> users = new ArrayList<User>();
            while(resultSet.next()){
                User user = new User(resultSet.getString("username"),resultSet.getString("password"));
                user.setUid(resultSet.getInt("uid"));
                users.add(user);
            }
            return users;
        }catch (SQLException s){
            s.printStackTrace();
        } finally {
            if(resultSet != null) resultSet.close();
            if(st != null) st.close();
            if(connection != null) connection.close();
        }
        return null;
    }
}
