package com.DAO;

import com.beans.Cart;
import com.beans.Commodity;
import com.service.CommodityService;
import com.tuils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDao {
    public static int insert(String cartID,int cid, int num) throws Exception{
        Connection connection = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            int id = -1;
            connection = DBUtil.getDs().getConnection();
           st = connection.prepareStatement("insert into cart(cartid,commodity, num) values(?,?,?)");
           st.setString(1,cartID);
           st.setInt(2,cid);
           st.setInt(3,num);
           int res = st.executeUpdate();
           return res;
       } catch (SQLException e){
           e.printStackTrace();
       } finally {
            if(st!=null) st.close();
            if(connection != null) connection.close();
        }
       return 0;
    }

    public static int update(String cartID,int cid, int num) throws Exception{
        Connection connection = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            connection = DBUtil.getDs().getConnection();
            st = connection.prepareStatement("update cart set num=? where cartid=? and commodity=?");
            st.setInt(1,num);
            st.setString(2,cartID);
            st.setInt(3,cid);
            int res = st.executeUpdate();
            return res;
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if(st!=null) st.close();
            if(connection != null)connection.close();
        }
        return 0;
    }

    public static List<Cart> select(String cartID) throws SQLException {
        Connection connection = null;
        PreparedStatement st = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getDs().getConnection();
            st = connection.prepareStatement("select * from cart where cartid=?");
            st.setString(1,cartID);
            resultSet = st.executeQuery();
            List<Cart> carts = new ArrayList<Cart>();
            while(resultSet.next()){
                Commodity commodity = CommodityService.getCommodityByCid(resultSet.getInt("commodity"));
                Cart cart = new Cart(cartID,commodity.getCname(),commodity.getPrice(), resultSet.getInt("num"));
                cart.setCommodityID(resultSet.getInt("commodity"));
                carts.add(cart);
            }
            return carts;
        } catch (SQLException s){
            s.printStackTrace();
        } finally {
            if(resultSet != null) resultSet.close();
            if(st != null) st.close();
            if(connection != null) connection.close();
        }
        return null;
    }

    public static Cart select(String cartid, int cid) throws SQLException {
        Connection connection = null;
        PreparedStatement st = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getDs().getConnection();
            st = connection.prepareStatement("select * from cart where cartid=? and commodity=?");
            st.setString(1,cartid);
            st.setInt(2,cid);
            resultSet = st.executeQuery();
            if(resultSet.next()){
                Cart cart = new Cart(resultSet.getInt("commodity"), resultSet.getInt("num"));
                cart.setCommodityID(resultSet.getInt("commodity"));
                return cart;
            }
        } catch (SQLException s){
            s.printStackTrace();
        } finally {
            if(resultSet != null) resultSet.close();
            if(st != null) st.close();
            if(connection != null)connection.close();
        }

        return null;
    }

    public static boolean exist(String cartid, int commodity) throws SQLException {
        Connection connection = DBUtil.getDs().getConnection();
        PreparedStatement st = null;
        ResultSet resultSet = null;
        try{
            st = connection.prepareStatement("select count(1) from cart where cartid=? and commodity= ?");
            st.setString(1,cartid);
            st.setInt(2,commodity);
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

    public static boolean delete(String username,int commodityID){
        Connection connection = null;
        PreparedStatement st = null;
        ResultSet resultSet = null;
        try{
            connection = DBUtil.getDs().getConnection();
            st = connection.prepareStatement("delete  from cart where cartid=? and commodity=?");
            st.setString(1,username);
            st.setInt(2,commodityID);
            int res = st.executeUpdate();
            return res > 0;
        } catch (SQLException s){
            s.printStackTrace();
        } finally {
            if(resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
