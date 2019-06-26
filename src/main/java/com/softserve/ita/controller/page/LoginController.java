package com.softserve.ita.controller.page;

import com.softserve.ita.controller.AbstractController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/login")
public class LoginController extends AbstractController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("uname");
        String pass = req.getParameter("pass");
        HttpSession session = req.getSession();
        session.setAttribute("username", uname);

        if(uname.equals("sasha") && pass.equals("kondrat")) {
            forwardToPage("page/carPage.jsp", req, resp);
        }
        else {
            forwardToPage("page/carPage.jsp", req, resp);
        }
    }
}
