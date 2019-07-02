package com.softserve.ita.controller.page;

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


@WebServlet("/search")
public class SearchController extends AbstractController {
    AdvertisementDAO adDAO;

    @Override
    public void init() throws ServletException {
        adDAO = new AdvertisementDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Advertisement> ads = null;
        String category = req.getParameter("category");
        String brand = req.getParameter("brand");
        String model = req.getParameter("model");
        int yearFrom = Integer.parseInt(req.getParameter("yearFrom"));
        int yearTo = Integer.parseInt(req.getParameter("yearTo"));
        int priceFrom = Integer.parseInt(req.getParameter("priceFrom"));
        int priceTo = Integer.parseInt(req.getParameter("priceTo"));

        try {
            ads = adDAO.selectAllWithFilters(category, brand, model, yearFrom, yearTo, priceFrom, priceTo);

            req.setAttribute("adList", ads);

            forwardToPage("page/searchPage.jsp", req, resp);

        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
