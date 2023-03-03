package com.service;

import com.DAO.CartDao;
import com.beans.Cart;

import java.sql.SQLException;
import java.util.List;

public class CartService {
    public static int addCommodity(String cartID,int cid, int num){
        try {
            if(CartDao.exist(cartID, cid)){
                Cart cart = CartDao.select(cartID, cid);
                if(cart == null){
                    return -1;
                }
                int res = CartDao.update(cartID,cid, num+cart.getNum());
                return  res;
            } else {
                int res = CartDao.insert(cartID,cid, num);
                return res;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static List<Cart> getCommodities(String cartID){
        try {
            List<Cart> carts = CartDao.select(cartID);
            return carts;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int updateCart(String cartid, int commodityID){
        try {

           int i =  CartDao.update(cartid,commodityID,0);
           if(i != 0) return i;
           else return -1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static boolean deleteCart(String username, int commodityID){
        boolean delete = CartDao.delete(username, commodityID);
        return delete;
    }
}
