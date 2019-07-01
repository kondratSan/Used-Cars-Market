package com.softserve.ita.dao;

import com.softserve.ita.model.Advertisement;
import com.softserve.ita.util.ConnectionPool;
import com.softserve.ita.util.DBUtil;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdvertisementDAO {

//    public void test() throws SQLException {
//        Connection conn = ConnectionPool.getConnection();
//
//        PreparedStatement statement = conn.prepareStatement("insert into brand(brandName) values\n" + "(\"kk\");",  PreparedStatement.RETURN_GENERATED_KEYS);
//
//        int check = statement.executeUpdate();
//
//        ResultSet rs = null;
//
//        rs = statement.getGeneratedKeys();
//
//        if (rs.next()) {
//            System.out.println(rs.getInt(1));
//        }
//    }

    public boolean addAdvertisement(Advertisement ad) {

        Integer car_id = ad.getCar_id();
        String description = ad.getDescription();
        Integer price = ad.getPrice();
        String title = ad.getTitle();
        Integer user_id = ad.getUser_id();
        PreparedStatement statement = null;



        try (Connection conn = ConnectionPool.getConnection()) {
            String query = "INSERT INTO advertisement (car_id, description, carPrice, title, user_id) " +
                    "values (?, ?, ?, ?, ?)";

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
}
