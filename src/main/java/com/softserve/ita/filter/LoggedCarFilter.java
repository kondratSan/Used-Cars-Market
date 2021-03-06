package com.softserve.ita.filter;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/car")
public class LoggedCarFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession(true);

        session.setAttribute("ad_id", req.getParameter("ad_id"));

        if (session.getAttribute("user") == null) {
            chain.doFilter(req, res);
        } else {

            res.sendRedirect("/loggedCar");
        }
    }
}
