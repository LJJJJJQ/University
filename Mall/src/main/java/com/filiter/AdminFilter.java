package com.filiter;

import com.beans.Commodity;
import com.beans.User;
import com.service.DisplayService;
import com.service.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebFilter(urlPatterns = {"/admin/admin.jsp"})
public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpSession session = req.getSession();

        //获取所有商品
        List<Commodity> commodities = DisplayService.display();
        //获取所有用户
        List<User> users = UserService.getAllUsers();
        if(users != null){
            session.setAttribute("commodities",commodities);
            session.setAttribute("users",users);
            filterChain.doFilter(req,servletResponse);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
