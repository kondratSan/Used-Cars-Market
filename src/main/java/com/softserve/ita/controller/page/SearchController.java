package com.softserve.ita.controller.page;

import com.softserve.ita.controller.AbstractController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/search")
public class SearchController extends AbstractController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forwardToPage("page/searchPage.jsp", req, resp);
    }
}
