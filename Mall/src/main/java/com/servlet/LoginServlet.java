package com.servlet;

import com.DAO.UserDao;
import com.beans.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println(username + " --- " + password);
        try {
            if(UserDao.login(username,password)){
                User user = new User(username,password);
                System.out.println(user.getCartID());
                session.setAttribute("user",user);
                if("root".equals(username)) resp.sendRedirect("/admin/admin.jsp");
                else resp.sendRedirect("/display.jsp");
            } else {
                resp.sendRedirect("/index.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
