package com.softserve.ita.controller.page.logged;

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


@WebServlet("/loggedCar")
public class LoggedCarController extends AbstractController {

    private CarDAO carDAO;
    private UserDAO userDAO;
    private AdvertisementDAO adDAO;

    @Override
    public void init() throws ServletException {
        carDAO = new CarDAO();
        userDAO = new UserDAO();
        adDAO = new AdvertisementDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);

        Integer id = Integer.parseInt((String)session.getAttribute("ad_id"));

        Advertisement ad  = adDAO.getAdById(id);

        req.setAttribute("ad", ad);
        forwardToPageLogged("page/carPage.jsp", req, resp);
    }
}
