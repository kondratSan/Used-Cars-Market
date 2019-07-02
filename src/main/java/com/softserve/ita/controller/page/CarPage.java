package com.softserve.ita.controller.page;

import com.softserve.ita.controller.AbstractController;
import com.softserve.ita.dao.AdvertisementDAO;
import com.softserve.ita.dao.CarDAO;
import com.softserve.ita.dao.UserDAO;
import com.softserve.ita.model.Advertisement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/car")
public class CarPage extends AbstractController {



    CarDAO carDAO;
    UserDAO userDAO;
    AdvertisementDAO adDAO;

    @Override
    public void init() throws ServletException {
        carDAO = new CarDAO();
        userDAO = new UserDAO();
        adDAO = new AdvertisementDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        System.out.println(req.getParameter("ad_id"));
        session.setAttribute("ad_id", req.getParameter("ad_id"));

        Integer id = Integer.parseInt(req.getParameter("ad_id"));
        Advertisement ad  = adDAO.getAdById(id);

        req.setAttribute("ad", ad);
        forwardToPage("page/carPage.jsp", req, resp);
    }
}
