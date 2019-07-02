package com.softserve.ita.filter;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/search")
public class LoggedSearchFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession(true);

        session.setAttribute("category", req.getParameter("category"));
        session.setAttribute("brand", req.getParameter("brand"));
        session.setAttribute("model", req.getParameter("model"));
        session.setAttribute("yearFrom", req.getParameter("yearFrom"));
        session.setAttribute("yearTo", req.getParameter("yearTo"));
        session.setAttribute("priceFrom", req.getParameter("priceFrom"));
        session.setAttribute("priceTo", req.getParameter("priceTo"));


        if (session.getAttribute("user") == null) {
            chain.doFilter(req, res);
        } else {
            res.sendRedirect("/loggedSearch");
        }
    }
}
