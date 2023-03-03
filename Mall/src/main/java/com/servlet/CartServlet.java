package com.servlet;

import com.beans.Cart;
import com.beans.User;
import com.service.CartService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/cartDel")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        int commodityID = Integer.parseInt(req.getParameter("param1"));

        boolean f = CartService.deleteCart(user.getUsername(), commodityID);
        if(f){
            resp.sendRedirect("/cart.jsp?param1=" + user.getUsername());
        } else {
            resp.getWriter().println("删除失败");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
