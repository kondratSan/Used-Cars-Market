package com.softserve.ita.filter;


import com.softserve.ita.model.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/admin-profile"})
public class AdminProfileFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession(true);
        User user = (User) session.getAttribute("user");

        if(session.getAttribute("user") == null){
            res.sendRedirect("/login-register");
        } else if(user.getRole().equals("user")){
            res.sendRedirect("/profile");
        } else if(user.getRole().equals("admin")){
            chain.doFilter(req, res);
        }

    }
}
