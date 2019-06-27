package com.softserve.ita.controller.page;

import com.softserve.ita.controller.AbstractController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/viewAllUsers")
public class ViewAllUsersController extends AbstractController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.getAttribute("email") == null){
            resp.sendRedirect("/home");
        } else {
            forwardToPage("page/viewAllUsers.jsp", req, resp);
        }    }
}
