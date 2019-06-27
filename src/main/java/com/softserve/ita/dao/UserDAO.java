package com.softserve.ita.dao;

import com.softserve.ita.model.User;
import com.softserve.ita.util.ConnectionPool;

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

        Connection conn = null;
        PreparedStatement preparedStatement = null;
        Statement st = null;

        try {
            conn = ConnectionPool.getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from user where email = \"" + email + "\"");
            if (rs.next()) {
                System.out.println("noway!");
                return "! Email already registered";  // On failure, send a message from here.
            }


            String query = "insert into user (firstName, lastName, email, age, phoneNumber, city, password) values (?,?,?,?,?,?,?)"; //Insert user details into the table 'USERS'
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
        }
        return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
    }

    public String authenticateUser(User user) {

        String email = user.getEmail(); //Keeping user entered values in temporary variables.
        String password = user.getPassword();

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        String query = "select * from user where email = ? and password = ?";

        try {
            conn = ConnectionPool.getConnection();
            statement = conn.prepareStatement(query); //Statement is used to write queries. Read more about it.
            statement.setString(1, email);
            statement.setString(2, password);
            resultSet = statement.executeQuery(); //Here table name is users and email,password are columns. fetching all the records and storing in a resultSet.

            if (resultSet.next()) {
                System.out.println(resultSet.getString("role"));
                return "SUCCESS";
            }

        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        }
        return "! Invalid user credentials"; // Just returning appropriate message otherwise
    }


    public User getUserById(int id) {
        User User = new User();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/usedcarsmarket?useSSL=false&serverTimezone=UTC", "root", "root");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * from user where id=" + id);
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
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return User;
    }


}
