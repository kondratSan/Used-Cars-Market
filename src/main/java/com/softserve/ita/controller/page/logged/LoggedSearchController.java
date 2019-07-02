package com.softserve.ita.controller.page.logged;

import com.softserve.ita.controller.AbstractController;
import com.softserve.ita.dao.AdvertisementDAO;
import com.softserve.ita.exception.DAOException;
import com.softserve.ita.model.Advertisement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet("/loggedSearch")
public class LoggedSearchController extends AbstractController {

    AdvertisementDAO adDAO;

    @Override
    public void init() throws ServletException {
        adDAO = new AdvertisementDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        List<Advertisement> ads = null;

        String category = (String) session.getAttribute("category");
        String brand = (String) session.getAttribute("brand");
        String model = (String) session.getAttribute("model");
        int yearFrom = Integer.parseInt((String) session.getAttribute("yearFrom"));
        int yearTo = Integer.parseInt((String) session.getAttribute("yearTo"));
        int priceFrom = Integer.parseInt((String) session.getAttribute("priceFrom"));
        int priceTo = Integer.parseInt((String) session.getAttribute("priceTo"));

        try {
            ads = adDAO.selectAllWithFilters(category, brand, model, yearFrom, yearTo, priceFrom, priceTo);
            req.setAttribute("adList", ads);
            forwardToPageLogged("page/searchPage.jsp", req, resp);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

}
