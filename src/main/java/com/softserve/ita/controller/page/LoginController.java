package com.softserve.ita.controller.page;

import com.softserve.ita.controller.AbstractController;
import com.softserve.ita.dao.UserDAO;
import com.softserve.ita.exception.DAOException;
import com.softserve.ita.model.User;
import com.softserve.ita.service.UserService;
import com.softserve.ita.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/login")
public class LoginController extends AbstractController {

    private UserService userService;
    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
        userService = new UserServiceImpl(userDAO);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        User user;
        try {
            user = userService.getUser(email, password);
            session.invalidate();
            session = request.getSession(true);
            session.setMaxInactiveInterval(15 * 60);
            session.setAttribute("role", user.getRole());
            session.setAttribute("user", user);
            session.setAttribute("email", user.getEmail());
            session.setAttribute("id", user.getId());
            response.sendRedirect("/loggedHome");
        } catch (DAOException e) {
            e.printStackTrace();
            request.setAttribute("loginErrMessage", "! Invalid user credentials"); //If authenticateUser() function returnsother than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
            forwardToPage("page/login-register.jsp", request, response);
        }
    }
}
