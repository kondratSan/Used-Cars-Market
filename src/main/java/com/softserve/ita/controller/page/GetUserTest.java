package com.softserve.ita.controller.page;


import com.softserve.ita.dao.UserDAO;
import com.softserve.ita.model.User;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getusertest")
public class GetUserTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        int id = Integer.parseInt(req.getParameter("id"));
        UserDAO dao = new UserDAO();
        User user = dao.getUserById(id);

        req.setAttribute("user", user);

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/JSP/test.jsp");
        rd.forward(req, resp);




    }
}
