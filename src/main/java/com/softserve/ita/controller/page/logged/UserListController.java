package com.softserve.ita.controller.page.logged;

import com.softserve.ita.controller.AbstractController;
import com.softserve.ita.dao.UserDAO;
import com.softserve.ita.exception.DAOException;
import com.softserve.ita.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/user-list")
public class UserListController extends AbstractController {
    UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        HttpSession session = req.getSession(true);

        try {

            List<User> users = userDAO.selectAll();

            req.setAttribute("userList", users);

            session.setAttribute("userList", users);


            forwardToPageLogged("page/admin/viewAllUsers.jsp", req, resp);

        } catch (DAOException | IOException e) {
            e.printStackTrace();
        }
    }
}

