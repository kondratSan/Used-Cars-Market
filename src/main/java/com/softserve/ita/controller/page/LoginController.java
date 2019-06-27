package com.softserve.ita.controller.page;

import com.softserve.ita.controller.AbstractController;
import com.softserve.ita.dao.UserDAO;
import com.softserve.ita.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/login")
public class LoginController extends AbstractController {
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

        User user = new User(); //creating object for LoginBean class, which is a normal java class, contains just setters and getters. Bean classes are efficiently used in java to access user information wherever required in the application.

        user.setEmail(email); //setting the username and password through the loginBean object then only you can get it in future.
        user.setPassword(password);

        UserDAO userDAO = new UserDAO(); //creating object for LoginDao. This class contains main logic of the application.

        String userValidate = userDAO.authenticateUser(user); //Calling authenticateUser function

        if (userValidate.equals("SUCCESS")) //If function returns success string then user will be rooted to Home page
        {
            HttpSession session = request.getSession();
            session.setAttribute("email", email);
            request.setAttribute("email", email); //with setAttribute() you can define a "key" and value pair so that you can get it in future using getAttribute("key")
            forwardToPage("page/home.jsp", request, response);
        } else {
            request.setAttribute("loginErrMessage", userValidate); //If authenticateUser() function returnsother than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
            forwardToPage("page/login-register.jsp", request, response);
        }
    }
}
