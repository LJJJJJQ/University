package com.servlet;

import com.beans.Commodity;
import com.service.CommodityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminUpdate")
public class AdminUpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cname = req.getParameter("cname");
        int num = Integer.parseInt(req.getParameter("num"));

        Commodity commodity = CommodityService.getCommodityInfo(cname);
        int res = CommodityService.updateCommodity(commodity.getCid(),num + commodity.getNum());
        if(res != -1) resp.sendRedirect("/admin/addSuccess.jsp");
        else resp.sendRedirect("/admin/addFailed.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
