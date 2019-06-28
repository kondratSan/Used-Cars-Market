package com.softserve.ita.dao;

import com.softserve.ita.model.User;
import com.softserve.ita.util.ConnectionPool;
import com.softserve.ita.util.DBUtil;

import java.sql.*;

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
        Statement st = null;
        ResultSet rs = null;

        try ( Connection conn = ConnectionPool.getConnection()){
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
            DBUtil.closeStatement(st);
        }
        return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
    }



    public User getUserByEmailAndPassword(String email, String password) {
        User User = new User();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        String query = "Select * from user where email = \"" + email + "\""
                + " and password = \"" + password + "\"";
        try(Connection conn = ConnectionPool.getConnection()){
            preparedStatement = conn.prepareStatement(query);
            rs = preparedStatement.executeQuery(query);
            if (rs.next()) {
                User.setId(rs.getInt("id"));
                User.setFirstName(rs.getString("firstName"));
                User.setLastName(rs.getString("lastName"));
                User.setEmail(rs.getString("email"));
                User.setAge(rs.getShort("age"));
                User.setPhoneNumber(rs.getString("phoneNumber"));
                User.setCity(rs.getString("city"));
                User.setPassword(rs.getString("password"));
                User.setRole(rs.getString("role"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(preparedStatement);
        }

        return User;
    }


}
