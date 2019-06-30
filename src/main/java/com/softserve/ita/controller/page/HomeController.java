package com.softserve.ita.controller.page;

import com.softserve.ita.controller.AbstractController;
import com.softserve.ita.dao.UserDAO;
import com.softserve.ita.exception.DAOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/home")
public class HomeController extends AbstractController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();
        try {
            userDAO.selectAll();
        } catch (DAOException e) {
            e.printStackTrace();
        }
        forwardToPage("page/home.jsp", req, resp);
    }
}
