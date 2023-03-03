package com.servlet;

import com.beans.User;
import com.service.CommodityService;
import com.service.ImgService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/adminAddCommodity")
public class AdminAddComdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

//        String cname = req.getParameter("cname");
//        System.out.println(cname);
//        int num = Integer.parseInt(req.getParameter("num"));
//        Double price = Double.parseDouble(req.getParameter("price"));
//        if("null".equals(cname) || num == -1 || price == -1){
//            resp.sendRedirect("/admin/addFailed.jsp");
//        } else {
            //        int res = CommodityService.addCommodity(cname,num,price);

            String savePath = this.getServletContext().getRealPath("/img"); //获取服务器在计算机中的真实路径
            String tmp = this.getServletContext().getRealPath("/WEB-INF/tmp");
        boolean f = ImgService.configImg(req, savePath, tmp);
        if(f) resp.sendRedirect("/admin/addSuccess.jsp");
        else resp.sendRedirect("/admin/addFailed.jsp");
//        if(res != -1) resp.sendRedirect("/admin/addSuccess.jsp");
//        else resp.sendRedirect("/admin/addFailed.jsp");
//        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
