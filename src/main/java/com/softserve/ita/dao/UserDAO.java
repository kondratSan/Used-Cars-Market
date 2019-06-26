package com.softserve.ita.dao;

import com.softserve.ita.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAO {

    public User getUserById(int id){
        User User = new User();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/usedcarsmarket?useSSL=false&serverTimezone=UTC", "root", "root");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * from user where id=" + id);
            if(rs.next()){
                User.setId(rs.getInt("id"));
                User.setFirstName(rs.getString("firstName"));
                User.setLastName(rs.getString("lastName"));
                User.setEmail(rs.getString("email"));
                User.setAge(rs.getShort("age"));
                User.setPhoneNumber(rs.getString("phoneNumber"));
                User.setCity_id(rs.getInt("city_id"));
                User.setPassword(rs.getString("password"));
                User.setRole(rs.getString("role"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return User;
    }
}
