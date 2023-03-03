package com.servlet;

import com.beans.Commodity;
import com.beans.User;
import com.service.CartService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/addCommodity")
public class AddCommodity2CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        Commodity commodity = (Commodity) session.getAttribute("commodity");

        boolean flag = true;
        //加入购物车
        String number = req.getParameter("number");
        int num = Integer.parseInt(number);
        if(commodity.getNum() - num < 0) resp.sendRedirect("/fail.jsp");
        else {
            int i = CartService.addCommodity(user.getUsername(), commodity.getCid(), num);
            System.out.println("addCommodity:" + i);
            if (i == -1) flag = false;
        }
        if(flag){
            System.out.println(user.getUsername());
            req.setAttribute("param1",user.getUsername());
            resp.sendRedirect("/cart.jsp?param1=" + user.getUsername());
        } else {
            resp.sendRedirect("/fail.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
