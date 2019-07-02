package com.softserve.ita.dao;

import com.softserve.ita.exception.DAOException;
import com.softserve.ita.model.Car;
import com.softserve.ita.model.User;
import com.softserve.ita.util.ConnectionPool;
import com.softserve.ita.util.DBUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Base64;

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

    public Car getCarById(Integer id) {
        Car car = null;

        PreparedStatement statement = null;

        ResultSet result = null;

        String sql = "SELECT * FROM car WHERE id = ?";


        try (Connection connection = ConnectionPool.getConnection()) {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            result = statement.executeQuery();

            if (result.next()) {
                car = new Car();
                String category = result.getString("category");
                String brand = result.getString("brand");
                String model = result.getString("model");
                int year = result.getInt("carYear");
                String fuel = result.getString("fuel");
                double volume = result.getDouble("engineVolume");
                int power = result.getInt("power");
                String transmission = result.getString("transmission");
                String carDrive = result.getString("carDrive");
                int kilometrage = result.getInt("kilometrage");
                String color = result.getString("color");
                Blob blob1 = result.getBlob("photo1");
                Blob blob2 = result.getBlob("photo2");
                Blob blob3 = result.getBlob("photo3");


                InputStream inputStream1 = blob1.getBinaryStream();
                ByteArrayOutputStream outputStream1 = new ByteArrayOutputStream();
                byte[] buffer1 = new byte[4096];
                int bytesRead1 = -1;

                while ((bytesRead1 = inputStream1.read(buffer1)) != -1) {
                    outputStream1.write(buffer1, 0, bytesRead1);
                }

                byte[] imageBytes1 = outputStream1.toByteArray();
                String base64Image1 = Base64.getEncoder().encodeToString(imageBytes1);

                inputStream1.close();
                outputStream1.close();

                car.setPhoto1out(base64Image1);

                InputStream inputStream2 = blob2.getBinaryStream();
                ByteArrayOutputStream outputStream2 = new ByteArrayOutputStream();
                byte[] buffer2 = new byte[4096];
                int bytesRead2 = -1;

                while ((bytesRead2 = inputStream2.read(buffer2)) != -1) {
                    outputStream2.write(buffer2, 0, bytesRead2);
                }

                byte[] imageBytes2 = outputStream2.toByteArray();
                String base64Image2 = Base64.getEncoder().encodeToString(imageBytes2);

                inputStream2.close();
                outputStream2.close();

                car.setPhoto2out(base64Image2);

                InputStream inputStream3 = blob3.getBinaryStream();
                ByteArrayOutputStream outputStream3 = new ByteArrayOutputStream();
                byte[] buffer3 = new byte[4096];
                int bytesRead3 = -1;

                while ((bytesRead3 = inputStream3.read(buffer3)) != -1) {
                    outputStream3.write(buffer3, 0, bytesRead3);
                }

                byte[] imageBytes3 = outputStream3.toByteArray();
                String base64Image3 = Base64.getEncoder().encodeToString(imageBytes3);

                inputStream3.close();
                outputStream3.close();

                car.setPhoto3out(base64Image3);

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

            }

        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }

        return car;
    }

    public boolean deleteCarById(Integer id) throws DAOException {
        PreparedStatement statement = null;

        ResultSet rs = null;


        try (Connection conn = ConnectionPool.getConnection()) {
            String query = "delete from car where id = " + id;

            statement = conn.prepareStatement(query);

            int check = statement.executeUpdate();

            if (check != 1) return true;


        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.closeStatement(statement);
        }

        return false;
    }


}
