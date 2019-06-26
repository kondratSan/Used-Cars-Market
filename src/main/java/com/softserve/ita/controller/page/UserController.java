package com.softserve.ita.controller.page;

import com.softserve.ita.controller.AbstractController;
import com.softserve.ita.dao.UserDAO;
import com.softserve.ita.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")
public class UserController extends AbstractController {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Copying all the input parameters in to local variables
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        int age = Integer.parseInt(request.getParameter("age"));
        String phoneNumber = request.getParameter("phoneNumber");
        String city = request.getParameter("city");
        String password = request.getParameter("password");



        User user = new User();
        //Using Java Beans - An easiest way to play with group of related data
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setAge(age);
        user.setPhoneNumber(phoneNumber);
        user.setCity(city);
        user.setPassword(password);

//        RegisterDao registerDao = new RegisterDao();
        UserDAO userDAO = new UserDAO();

        //The core Logic of the Registration application is present here. We are going to insert user data in to the database.
        String userRegistered = userDAO.addUser(user);

        if(userRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
        {
            response.sendRedirect("/home");
        }
        else   //On Failure, display a meaningful message to the User.
        {
            System.out.println(userRegistered);
            request.setAttribute("errMessage", userRegistered);

            forwardToPage("page/login-register.jsp", request, response);
        }
    }
}
