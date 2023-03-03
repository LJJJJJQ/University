package com.service;

import com.DAO.CommodityDao;
import com.beans.Commodity;
import java.util.List;

public class DisplayService {
    public static List<Commodity> display(){
        try {
            List<Commodity> commodities = CommodityDao.selectAll();
            return commodities;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
