package com.softserve.ita.controller.page;

import com.softserve.ita.controller.AbstractController;
import com.softserve.ita.dao.AdvertisementDAO;
import com.softserve.ita.dao.UserDAO;
import com.softserve.ita.exception.DAOException;
import com.softserve.ita.model.Advertisement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/home")
public class HomeController extends AbstractController {
    AdvertisementDAO adDAO;

    @Override
    public void init() throws ServletException {
        adDAO = new AdvertisementDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Advertisement> ads = null;
        try {
            ads = adDAO.selectAll();

            req.setAttribute("adList", ads);

            forwardToPage("page/home.jsp", req, resp);

        } catch (DAOException e) {
            e.printStackTrace();
        }


    }
}
