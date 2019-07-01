package com.softserve.ita.controller.page;

import com.softserve.ita.controller.AbstractController;
import com.softserve.ita.dao.CarDAO;
import com.softserve.ita.dao.ImageDAO;
import com.softserve.ita.model.Car;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class Test extends AbstractController {
    private static final long serialVersionUID = 1L;

    public Test() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        int bookId = Integer.parseInt(request.getParameter("id"));
        CarDAO dao = new CarDAO();

        Car car = dao.getCarById(26);

        request.setAttribute("car", car);

        forwardToPage("page/home.jsp", request, response);

    }
}
