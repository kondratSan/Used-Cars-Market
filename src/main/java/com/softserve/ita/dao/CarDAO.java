package com.softserve.ita.dao;

import com.softserve.ita.model.Car;
import com.softserve.ita.model.User;
import com.softserve.ita.util.ConnectionPool;
import com.softserve.ita.util.DBUtil;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

public class CarDAO {

    public Integer addCar(Car car) {
        String category = car.getCategory();
        String brand = car.getBrand();
        String model = car.getModel();
        int year = car.getCarYear();
        String fuel = car.getFuel();
        double volume = car.getEngineVolume();
        int power = car.getEnginePower();
        String transmission = car.getTransmission();
        String carDrive = car.getCarDrive();
        int kilometrage = car.getKilometrage();
        String color = car.getColor();
        InputStream photo1 = car.getPhoto1();
        InputStream photo2 = car.getPhoto2();
        InputStream photo3 = car.getPhoto3();

        PreparedStatement statement = null;

        ResultSet rs = null;


        try (Connection conn = ConnectionPool.getConnection()) {
            String query = "INSERT INTO car (category, brand, model, carYear, fuel, engineVolume, " + "power, transmission, carDrive, kilometrage, color, photo1, photo2, photo3) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            statement = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

            statement.setString(1, category);
            statement.setString(2, brand);
            statement.setString(3, model);
            statement.setInt(4, year);
            statement.setString(5, fuel);
            statement.setDouble(6, volume);
            statement.setInt(7, power);
            statement.setString(8, transmission);
            statement.setString(9, carDrive);
            statement.setInt(10, kilometrage);
            statement.setString(11, color);

            if (photo1 != null) {
                statement.setBlob(12, photo1);
            }

            if (photo2 != null) {
                statement.setBlob(13, photo2);
            }

            if (photo3 != null) {
                statement.setBlob(14, photo3);
            }

            int check = statement.executeUpdate();

            assert photo1 != null;
            photo1.close();
            assert photo2 != null;
            photo2.close();
            assert photo3 != null;
            photo3.close();

            rs = statement.getGeneratedKeys();

            if (check != 0 && rs.next()) {
                return rs.getInt(1);
            }


        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
            return 0;
        } finally {
            DBUtil.closeStatement(statement);
        }

        return 0;
    }
}
