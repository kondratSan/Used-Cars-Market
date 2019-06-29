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

@WebFilter(urlPatterns = {"/profile", "/admin-profile"})
public class AdminFProfileFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession(true);
        User user = (User) session.getAttribute("user");

        switch (user.getRole()) {
            case ("admin"):
                res.sendRedirect("/admin-profile");
                break;
            case ("user"):
                res.sendRedirect("/profile");
                break;
            default:
                res.sendRedirect("/login-register");
        }
//        if (!user.getRole().equals("admin")) {
//            res.sendRedirect("/profile");
//        } else {
//            res.sendRedirect("/admin-profile");
//        }
    }
}
