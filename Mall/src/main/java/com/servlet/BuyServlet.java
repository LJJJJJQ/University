package com.servlet;

import com.beans.Cart;
import com.beans.Commodity;
import com.beans.User;
import com.service.CartService;
import com.service.CommodityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/buy")
public class BuyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        //购买加入购物车

        List<Cart> carts = CartService.getCommodities(user.getUsername());
        Commodity commodity = null;

        //判断库存
        boolean flag = true;
        for (Cart cart:carts) {
            commodity = CommodityService.getCommodityInfo(cart.getCommodityName());
            if(commodity.getNum() - cart.getNum() < 0) flag = false;
        }

        if(flag){
            //更新库存
            int i = -1,i1 = -1;
            for (Cart cart:carts) {
                commodity = CommodityService.getCommodityInfo(cart.getCommodityName());
                i1 = CommodityService.updateCommodity(commodity.getCid(), commodity.getNum() - cart.getNum());
                i = CartService.updateCart(cart.getCid(), commodity.getCid());
            }

            if(i != -1 && i1 != -1){
                resp.sendRedirect("/success.jsp");
            } else {
                resp.sendRedirect("/fail.jsp");
            }
        } else {
            resp.sendRedirect("/fail.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
