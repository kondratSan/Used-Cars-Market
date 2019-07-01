package com.softserve.ita.controller.page;

import com.softserve.ita.controller.AbstractController;
import com.softserve.ita.dao.CarDAO;
import com.softserve.ita.model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/car")
public class CarPage extends AbstractController {

    CarDAO carDAO;

    @Override
    public void init() throws ServletException {
        carDAO = new CarDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = Integer.parseInt(req.getParameter("car_id"));
        System.out.println(id + "Wattahel??????");
        Car car = carDAO.getCarById(27);

        req.setAttribute("car", car);
        forwardToPage("page/carPage.jsp", req, resp);
    }
}
