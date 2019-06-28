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

    //    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String uname = req.getParameter("uname");
//        String pass = req.getParameter("pass");
//        HttpSession session = req.getSession();
//        session.setAttribute("username", uname);
//
//        if(uname.equals("sasha") && pass.equals("kondrat")) {
//            forwardToPage("page/carPage.jsp", req, resp);
//        }
//        else {
//            forwardToPage("page/carPage.jsp", req, resp);
//        }
//    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        User user = null;
        try {
            user = userService.getUser(email, password);
            if(user != null){
                session.invalidate();
                session = request.getSession(true);
                session.setMaxInactiveInterval(15 * 60);
                session.setAttribute("role", user.getRole());
                session.setAttribute("user", user);
                session.setAttribute("email", user.getEmail());
                response.sendRedirect("/home");
            } else {
                request.setAttribute("loginErrMessage", "! Invalid user credentials"); //If authenticateUser() function returnsother than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
                forwardToPage("page/login-register.jsp", request, response);
            }
        } catch (DAOException e) {
            e.getMessage();
        }
    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String email = request.getParameter("email");
//        String password = request.getParameter("password");
//        HttpSession session = request.getSession();
//
//
//        User user = null;
//        try {
//            user = userService.getUser(email, password);
//        } catch (DAOException e) {
//            e.printStackTrace();
//        }
//        if(user == null){
//            request.setAttribute("loginErrMessage", "! Invalid user credentials"); //If authenticateUser() function returnsother than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
//            forwardToPage("page/login-register.jsp", request, response);
//            return;
//        }
//
//
//        String userValidate = userDAO.authenticateUser(user);
//
//        if (userValidate.equals("SUCCESS")) //If function returns success string then user will be rooted to Home page
//        {
//            session.invalidate();
//            session = request.getSession(true);
//            session.setMaxInactiveInterval(15 * 60);
//            session.setAttribute("role", user.getRole());
//            session.setAttribute("user", user);
//            session.setAttribute("email", user.getEmail());
//            response.sendRedirect("/home");
//        } else {
//            request.setAttribute("loginErrMessage", userValidate); //If authenticateUser() function returnsother than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
//            forwardToPage("page/login-register.jsp", request, response);
//        }
//    }
}
