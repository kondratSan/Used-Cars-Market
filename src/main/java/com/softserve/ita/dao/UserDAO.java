package com.softserve.ita.dao;

import com.softserve.ita.exception.DAOException;
import com.softserve.ita.model.User;
import com.softserve.ita.util.ConnectionPool;
import com.softserve.ita.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public String addUser(User user) {
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String email = user.getEmail();
        int age = user.getAge();
        String phoneNumber = user.getPhoneNumber();
        String city = user.getCity();
        String password = user.getPassword();

        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try (Connection conn = ConnectionPool.getConnection()) {
            String query = "Select * from user where email = \"" + email + "\"";
            preparedStatement = conn.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return "! Email already registered";  // On failure, send a message from here.
            }
            query = "insert into user (firstName, lastName, email, age, phoneNumber, city, password) values (?,?,?,?,?,?,?)"; //Insert user details into the table 'USERS'
            preparedStatement = conn.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, email);
            preparedStatement.setInt(4, age);
            preparedStatement.setString(5, phoneNumber);
            preparedStatement.setString(6, city);
            preparedStatement.setString(7, password);

            int i = preparedStatement.executeUpdate();

            if (i != 0)  //Just to ensure data has been inserted into the database
                return "SUCCESS";
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(preparedStatement);
        }
        return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
    }


    public User getUserByEmailAndPassword(String email, String password) {
        User user = new User();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        String query = "Select * from user where email = \"" + email + "\"" + " and password = \"" + password + "\"";
        try (Connection conn = ConnectionPool.getConnection()) {
            preparedStatement = conn.prepareStatement(query);
            rs = preparedStatement.executeQuery(query);
            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setEmail(rs.getString("email"));
                user.setAge(rs.getShort("age"));
                user.setPhoneNumber(rs.getString("phoneNumber"));
                user.setCity(rs.getString("city"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(preparedStatement);
        }

        return user;
    }

    public List<User> selectAll() throws DAOException {
        List<User> users = new ArrayList<>();

        User user;

        PreparedStatement stmt = null;
        ResultSet rs = null;

        String query = "SELECT * from user";

        try (Connection conn = ConnectionPool.getConnection()) {

            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setEmail(rs.getString("email"));
                user.setAge(rs.getShort("age"));
                user.setPhoneNumber(rs.getString("phoneNumber"));
                user.setCity(rs.getString("city"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                users.add(user);
            }

            return users;
        } catch (SQLException e) {
            throw new DAOException(e.getMessage(), e);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(stmt);
        }

    }

    public User getUserById(Integer id) {
        User user = new User();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        String query = "Select * from user where id = " + id ;
        try (Connection conn = ConnectionPool.getConnection()) {
            preparedStatement = conn.prepareStatement(query);
            rs = preparedStatement.executeQuery(query);
            if (!rs.next()) {
                return null;
            } else {
                user.setId(rs.getInt("id"));
                user.setLastName(rs.getString("lastName"));
                user.setFirstName(rs.getString("firstName"));
                user.setEmail(rs.getString("email"));
                user.setAge(rs.getShort("age"));
                user.setPhoneNumber(rs.getString("phoneNumber"));
                user.setCity(rs.getString("city"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(preparedStatement);
        }

        return user;
    }

    public String deleteUserById(Integer id) throws DAOException {
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        String query = "Delete from user where id = " + id;
        AdvertisementDAO adDAO = new AdvertisementDAO();
        CarDAO carDAO = new CarDAO();
        List<Integer> car_ids = adDAO.selectAllCarIdsByUserId(id);
        for (Integer car_id : car_ids) {
            carDAO.deleteCarById(car_id);
        }

        try (Connection conn = ConnectionPool.getConnection()) {

            preparedStatement = conn.prepareStatement(query);

            int check = preparedStatement.executeUpdate();

            if (check != 0)
                return "User Has been successfully deleted!";

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(preparedStatement);
        }

        return "There was an error with deleting user!";
    }


}
