package com.softserve.ita.controller.page.logged;

import com.softserve.ita.controller.AbstractController;
import com.softserve.ita.dao.AdvertisementDAO;
import com.softserve.ita.dao.CarDAO;
import com.softserve.ita.dao.UserDAO;
import com.softserve.ita.model.Advertisement;
import com.softserve.ita.model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/sellCarSubmit")
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class SubmitSellCarController extends AbstractController {


    private CarDAO carDAO;
    private AdvertisementDAO adDAO;

    @Override
    public void init() throws ServletException {
        adDAO = new AdvertisementDAO();
        carDAO = new CarDAO();
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();


        String category = request.getParameter("category");
        String brand = request.getParameter("brand");
        String model = request.getParameter("model");
        int year = Integer.parseInt(request.getParameter("year"));
        String fuel = request.getParameter("fuel");
        double volume = Double.parseDouble(request.getParameter("volume"));
        int power = Integer.parseInt(request.getParameter("power"));
        String transmission = request.getParameter("transmission");
        String carDrive = request.getParameter("carDrive");
        int kilometrage = Integer.parseInt(request.getParameter("kilometrage"));
        String color = request.getParameter("color");

        InputStream inputStream1 = null;
        InputStream inputStream2 = null;
        InputStream inputStream3 = null;

        Part filePart = request.getPart("photo1");
        inputStream1 = filePart.getInputStream();

        filePart = request.getPart("photo2");
        inputStream2 = filePart.getInputStream();

        filePart = request.getPart("photo3");
        inputStream3 = filePart.getInputStream();

        Car car = new Car();

        car.setCategory(category);
        car.setBrand(brand);
        car.setModel(model);
        car.setCarYear(year);
        car.setFuel(fuel);
        car.setEngineVolume(volume);
        car.setEnginePower(power);
        car.setTransmission(transmission);
        car.setCarDrive(carDrive);
        car.setKilometrage(kilometrage);
        car.setColor(color);
        car.setPhoto1(inputStream1);
        car.setPhoto2(inputStream2);
        car.setPhoto3(inputStream3);

        Integer car_id = null;
        String description = request.getParameter("description");
        Integer price = Integer.parseInt(request.getParameter("price"));
        String title = request.getParameter("title");
        Integer user_id = (Integer) session.getAttribute("id");

        car_id = carDAO.addCar(car);
        if (car_id != 0) {

            Advertisement ad = new Advertisement();
            ad.setCar_id(car_id);
            ad.setDescription(description);
            ad.setTitle(title);
            ad.setPrice(price);
            ad.setUser_id(user_id);
            if (adDAO.addAdvertisement(ad)) {
                request.setAttribute("message", "Your car has been successfully added!");
                forwardToPageLogged("page/sellCar.jsp", request, response);
            }
        } else {
            request.setAttribute("message", "There was a problem with adding your car!");
            forwardToPageLogged("page/sellCar.jsp", request, response);
        }


    }
}