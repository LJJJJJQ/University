package com.service;

import com.DAO.CommodityDao;
import com.beans.Commodity;

import java.sql.SQLException;

public class CommodityService {
    public static Commodity getCommodityInfo(String name){
        try {
            Commodity commodity = CommodityDao.select(name);
            return commodity;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return null;
    }

    public static Commodity getCommodityByCid(int cid){
        try {
            Commodity commodity = CommodityDao.select(cid);
            return commodity;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int updateCommodity(int cid,int num){
        try {
            int res = CommodityDao.update(cid,num);
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static int addCommodity(String cname, int num, double price){
        int res = CommodityDao.insert(cname, num, price);
        return res;
    }

    public static int deleteCommodity(String cname){
        int res = CommodityDao.delete(cname);
        return res;
    }
}
