package com.DAO;

import com.beans.Commodity;
import com.tuils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommodityDao {
    public static List<Commodity> selectAll() throws Exception{
        Connection connection = null;
        PreparedStatement st = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getDs().getConnection();
            st = connection.prepareStatement("select * from commodity");
            resultSet = st.executeQuery();
            List<Commodity> commodities = new ArrayList<Commodity>();
            while(resultSet.next()) {
                Commodity commodity = new Commodity(resultSet.getInt("cid"), resultSet.getString("cname"), resultSet.getDouble("price"), resultSet.getInt("num"));
                commodities.add(commodity);
            }
            return commodities;
        } catch (SQLException s){
            s.printStackTrace();
        } finally{
            if(resultSet != null) resultSet.close();
            if(st != null) st.close();
            if(connection != null) connection.close();
        }
        return null;
    }

    public static int update(int cid, int num) throws SQLException {
        Connection connection = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            connection = DBUtil.getDs().getConnection();
            st = connection.prepareStatement("update commodity set num=? where cid=? ");
            st.setInt(1,num);
            st.setInt(2,cid);
            int res = st.executeUpdate();
            return res;
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if(rs != null) rs.close();
            if(st!=null) st.close();
            if(connection != null) connection.close();
        }
        return 0;
    }

    public static int update(String cname, int num) throws SQLException {
        Connection connection = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            connection = DBUtil.getDs().getConnection();
            st = connection.prepareStatement("update commodity set num=? where cname=? ");
            st.setInt(1,num);
            st.setString(2,cname);
            int res = st.executeUpdate();
            return res;
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if(rs != null) rs.close();
            if(st!=null) st.close();
            if(connection != null) connection.close();
        }
        return 0;
    }

    public static Commodity select(String name) throws SQLException {
        Connection connection = null;
        PreparedStatement st = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getDs().getConnection();
            st = connection.prepareStatement("select * from commodity where cname=?");
            st.setString(1,name);
            resultSet = st.executeQuery();
            if(resultSet.next()) return new Commodity(resultSet.getInt("cid"), resultSet.getString("cname"), resultSet.getDouble("price"), resultSet.getInt("num"));
        } catch (SQLException s){
            s.printStackTrace();
        } finally {
            if(resultSet != null) resultSet.close();
            if(st != null) st.close();
            if(connection != null) connection.close();
        }
        return null;
    }

    public static Commodity select(int cid) throws SQLException {
        Connection connection = null;
        PreparedStatement st = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getDs().getConnection();
            st = connection.prepareStatement("select * from commodity where cid=?");
            st.setInt(1,cid);
            resultSet = st.executeQuery();
            if(resultSet.next()) return new Commodity(resultSet.getInt("cid"), resultSet.getString("cname"), resultSet.getDouble("price"), resultSet.getInt("num"));
        } catch (SQLException s){
            s.printStackTrace();
        } finally {
            if(resultSet != null) resultSet.close();
            if(st != null) st.close();
            if(connection != null) connection.close();
        }
        return null;
    }

    public static int delete(String cname) {
        Connection connection = null;
        PreparedStatement st = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getDs().getConnection();
            st = connection.prepareStatement("delete from commodity where cname=?");
            st.setString(1,cname);
            int res = st.executeUpdate();
            return res;
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
        return -1;
    }
    public static int insert(String cname, int num, double price){
        Connection connection = null;
        PreparedStatement st = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getDs().getConnection();
            st = connection.prepareStatement("insert into commodity(cname,price,num) values (?,?,?)");
            st.setString(1,cname);
            st.setDouble(2,price);
            st.setInt(3,num);
            int res = st.executeUpdate();
            return res;
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
        return -1;
    }
    }
