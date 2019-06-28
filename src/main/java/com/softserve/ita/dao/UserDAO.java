package com.softserve.ita.dao;

import com.softserve.ita.model.User;
import com.softserve.ita.util.ConnectionPool;
import com.softserve.ita.util.DBUtil;

import java.sql.*;
import java.util.Optional;

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
            st = conn.createStatement();
            rs = st.executeQuery("Select * from user where email = \"" + email + "\"");
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
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeStatement(st);
        }
        return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
    }

    public String authenticateUser(User user) {

        String email = user.getEmail(); //Keeping user entered values in temporary variables.
        String password = user.getPassword();

        PreparedStatement preparedStatement= null;
        ResultSet resultSet = null;

        String query = "select * from user where email = ? and password = ?";

        try (Connection conn =  ConnectionPool.getConnection()){
            preparedStatement = conn.prepareStatement(query); //Statement is used to write queries. Read more about it.
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery(); //Here table name is users and email,password are columns. fetching all the records and storing in a resultSet.

            if (resultSet.next()) {
                System.out.println(resultSet.getString("role"));
                return "SUCCESS";
            }

        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(preparedStatement);
        }
        return "! Invalid user credentials"; // Just returning appropriate message otherwise
    }

//    public Optional<User> loadByEmail(String email) throws DAOException {
//        return Optional.ofNullable(databaseManager.executeQuery("SELECT * FROM users WHERE email=?",
//                this::fetchUserFromResultSet,
//                email));
//    }
//
//    private User fetchUserFromResultSet(ResultSet resultSet) throws SQLException {
//        if (resultSet.next()) {
//            User user = new User();
//            user.setId(resultSet.getLong("id"));
//            user.setName(resultSet.getString("name"));
//            user.setSurname(resultSet.getString("surname"));
//            user.setEmail(resultSet.getString("email"));
//            user.setPassword(resultSet.getString("password"));
//            user.setAccountNumber(resultSet.getLong("account_number"));
//            user.setRole(UserRole.valueOf(resultSet.getByte("role")));
//            return user;
//        } else {
//            return null;
//        }
//    }


    public User getUserByEmailAndPassword(String email, String password) {
        User User = new User();
        Statement st = null;
        ResultSet rs = null;
        String query = "Select * from user where email = \"" + email + "\""
                + " and password = \"" + password + "\"";
        try(Connection conn = ConnectionPool.getConnection()){
            st = conn.createStatement();
            rs = st.executeQuery(query);
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
            DBUtil.closeStatement(st);
        }

        return User;
    }


}
