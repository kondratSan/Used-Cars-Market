package com.softserve.ita.dao;

import com.softserve.ita.exception.DAOException;
import com.softserve.ita.model.Advertisement;
import com.softserve.ita.model.Car;
import com.softserve.ita.model.User;
import com.softserve.ita.util.ConnectionPool;
import com.softserve.ita.util.DBUtil;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdvertisementDAO {

    private UserDAO userDAO = new UserDAO();
    private CarDAO carDAO = new CarDAO();

    public boolean addAdvertisement(Advertisement ad) {

        Integer car_id = ad.getCar_id();
        String description = ad.getDescription();
        Integer price = ad.getPrice();
        String title = ad.getTitle();
        Integer user_id = ad.getUser_id();
        PreparedStatement statement = null;


        try (Connection conn = ConnectionPool.getConnection()) {
            String query = "INSERT INTO advertisement (car_id, description, carPrice, title, user_id) " + "values (?, ?, ?, ?, ?)";

            statement = conn.prepareStatement(query);

            statement.setInt(1, car_id);
            statement.setString(2, description);
            statement.setInt(3, price);
            statement.setString(4, title);
            statement.setInt(5, user_id);

            int check = statement.executeUpdate();

            if (check != 0) {
                return true;
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            DBUtil.closeStatement(statement);
        }

        return false;
    }

    public Advertisement getAdById(Integer id) {
        Advertisement ad = new Advertisement();
        User user = null;
        Car car = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        String query = "Select * from advertisement where id = " + id;
        try (Connection conn = ConnectionPool.getConnection()) {
            preparedStatement = conn.prepareStatement(query);
            rs = preparedStatement.executeQuery(query);
            if (rs.next()) {
                ad.setId(rs.getInt("id"));
                ad.setCar_id(rs.getInt("car_id"));
                ad.setUser_id(rs.getInt("user_id"));
                ad.setDescription(rs.getString("description"));
                ad.setPrice(rs.getInt("carPrice"));
                ad.setTitle(rs.getString("title"));
                user = userDAO.getUserById(rs.getInt("user_id"));
                car = carDAO.getCarById(rs.getInt("car_id"));
                ad.setUser(user);
                ad.setCar(car);
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(preparedStatement);
        }

        return ad;
    }

    public List<Advertisement> selectAll() throws DAOException {
        List<Advertisement> ads = new ArrayList<>();

        Advertisement ad;
        User user = null;
        Car car = null;

        PreparedStatement stmt = null;
        ResultSet rs = null;

        String query = "SELECT * from advertisement";

        try (Connection conn = ConnectionPool.getConnection()) {

            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ad = new Advertisement();
                ad.setId(rs.getInt("id"));
                ad.setCar_id(rs.getInt("car_id"));
                ad.setUser_id(rs.getInt("user_id"));
                ad.setDescription(rs.getString("description"));
                ad.setPrice(rs.getInt("carPrice"));
                ad.setTitle(rs.getString("title"));
                user = userDAO.getUserById(rs.getInt("user_id"));
                car = carDAO.getCarById(rs.getInt("car_id"));
                ad.setUser(user);
                ad.setCar(car);
                ads.add(ad);
            }

            return ads;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(stmt);
        }
        return null;
    }

    public List<Advertisement> selectAllWithFilters(String category, String brand, String model, int yearFrom, int yearTo, int priceFrom, int priceTo) throws DAOException {
        List<Advertisement> ads = new ArrayList<>();


        Advertisement ad;
        Car car = null;
        User user = null;

        PreparedStatement stmt = null;
        ResultSet rs = null;

        String query = "SELECT * from advertisement join car where (car.category = ? or ? = 1) and " + "(car.brand = ? or ? = 1) and (car.model = ? or ? = 1) and ((car.carYear between ? and ?) or ? = 1) " + "and ((advertisement.carPrice between ? and ?) or ? = 1) and(advertisement.car_id = car.id)";

        try (Connection conn = ConnectionPool.getConnection()) {

            stmt = conn.prepareStatement(query);

            stmt.setString(1, category);

            if (category.equals("")) stmt.setInt(2, 1);
            else stmt.setInt(2, 0);

            stmt.setString(3, brand);

            if (brand.equals("")) stmt.setInt(4, 1);
            else stmt.setInt(4, 0);

            stmt.setString(5, model);

            if (model.equals("")) stmt.setInt(6, 1);
            else stmt.setInt(6, 0);

            stmt.setInt(7, yearFrom);
            stmt.setInt(8, yearTo);

            if (yearFrom < 0) stmt.setInt(9, 1);
            else stmt.setInt(9, 0);

            stmt.setInt(10, priceFrom);
            stmt.setInt(11, priceTo);

            if (priceFrom < 0) stmt.setInt(12, 1);
            else stmt.setInt(12, 0);


            rs = stmt.executeQuery();

            while (rs.next()) {
                ad = new Advertisement();
                ad.setId(rs.getInt("advertisement.id"));
                ad.setCar_id(rs.getInt("advertisement.car_id"));
                ad.setUser_id(rs.getInt("advertisement.user_id"));
                ad.setDescription(rs.getString("advertisement.description"));
                ad.setTitle(rs.getString("advertisement.title"));
                ad.setPrice(rs.getInt("advertisement.carPrice"));
                user = userDAO.getUserById(rs.getInt("advertisement.user_id"));
                car = carDAO.getCarById(rs.getInt("advertisement.car_id"));
                ad.setUser(user);
                ad.setCar(car);
                ads.add(ad);
            }

            return ads;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(stmt);
        }
        return null;
    }

    public List<Integer> selectAllCarIdsByUserId(Integer user_id) throws DAOException {
        List<Integer> car_ids = new ArrayList<>();

        PreparedStatement stmt = null;
        ResultSet rs = null;


        String query = "SELECT car_id from advertisement where advertisement.user_id = " + user_id;

        try (Connection conn = ConnectionPool.getConnection()) {

            stmt = conn.prepareStatement(query);

            rs = stmt.executeQuery();

            while (rs.next()) {
                car_ids.add(rs.getInt("car_id"));
            }

            return car_ids;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(stmt);
        }
        return null;
    }

    public List<Advertisement> selectAllByUserId(Integer user_id) throws DAOException {
        List<Advertisement> ads = new ArrayList<>();

        Advertisement ad;
        User user = null;
        Car car = null;

        PreparedStatement stmt = null;
        ResultSet rs = null;

        String query = "SELECT * from advertisement where advertisement.user_id = " + user_id;

        try (Connection conn = ConnectionPool.getConnection()) {

            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ad = new Advertisement();
                ad.setId(rs.getInt("id"));
                ad.setUser_id(rs.getInt("user_id"));
                ad.setCar_id(rs.getInt("car_id"));
                ad.setDescription(rs.getString("description"));
                ad.setPrice(rs.getInt("carPrice"));
                ad.setTitle(rs.getString("title"));
                user = userDAO.getUserById(rs.getInt("user_id"));
                car = carDAO.getCarById(rs.getInt("car_id"));
                ad.setUser(user);
                ad.setCar(car);
                ads.add(ad);
            }


            return ads;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(stmt);
        }
        return null;
    }


}
