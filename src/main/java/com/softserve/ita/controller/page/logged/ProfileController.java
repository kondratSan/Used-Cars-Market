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

@WebServlet("/profile")
public class ProfileController extends AbstractController {
    AdvertisementDAO adDAO;

    @Override
    public void init() throws ServletException {
        adDAO = new AdvertisementDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);

        List<Advertisement> ads = null;


        try {


            ads = adDAO.selectAllByUserId((Integer) session.getAttribute("id"));

            req.setAttribute("adList", ads);

            forwardToPageLogged("page/profile.jsp", req, resp);

        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}

