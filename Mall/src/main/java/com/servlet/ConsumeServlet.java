package com.servlet;

import com.beans.Commodity;
import com.service.CommodityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/consumption")
public class ConsumeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        String param1 = req.getParameter("param1");
        System.out.println(param1);

        Commodity commodity = CommodityService.getCommodityInfo(param1);
        if(commodity != null){
            session.setAttribute("commodity",commodity);
            resp.sendRedirect("/consumption.jsp");
        } else {
            resp.sendRedirect("/display.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
