package com.softserve.ita.controller.page;

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

@WebServlet("/user")
public class UserController extends AbstractController {

    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        int age = Integer.parseInt(request.getParameter("age"));
        String phoneNumber = request.getParameter("phoneNumber");
        String city = request.getParameter("city");
        String password = request.getParameter("password");


        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setAge(age);
        user.setPhoneNumber(phoneNumber);
        user.setCity(city);
        user.setPassword(password);

        String userRegistered = userDAO.addUser(user);

        if (userRegistered.equals("SUCCESS")) {
            response.sendRedirect("/home");
        } else {
            request.setAttribute("errMessage", userRegistered);
            forwardToPage("page/login-register.jsp", request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String message;
        int user_id = Integer.parseInt(req.getParameter("user_id"));
        try {
            message = userDAO.deleteUserById(user_id);
            req.setAttribute("userList", session.getAttribute("userList"));
            req.setAttribute("deleteMessage", message);
            forwardToPageLogged("page/admin/viewAllUsers.jsp", req, resp);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}

