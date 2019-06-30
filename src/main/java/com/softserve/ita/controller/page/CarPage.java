package com.softserve.ita.controller.page;

import com.softserve.ita.controller.AbstractController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/car")
public class CarPage extends AbstractController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession();
////        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
//        if(session.getAttribute("email") == null){
//            resp.sendRedirect("/home");
//        } else {
//        }
        forwardToPage("page/carPage.jsp", req, resp);
    }
}
