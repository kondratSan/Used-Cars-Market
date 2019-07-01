package com.softserve.ita.dao;

import com.softserve.ita.exception.DAOException;
import com.softserve.ita.model.Car;
import com.softserve.ita.util.ConnectionPool;
import com.softserve.ita.util.DBUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Base64;

public class ImageDAO {


//    public Car get(int id) throws SQLException, IOException {
//        Car car = null;
//
//        String sql = "SELECT * FROM car WHERE id = ?";
//
//        try (Connection connection = ConnectionPool.getConnection()) {
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setInt(1, 26);
//            ResultSet result = statement.executeQuery();
//
//            if (result.next()) {
//                car = new Car();
////                String title = result.getString("title");
////                String author = result.getString("author");
//                Blob blob = result.getBlob("photo1");
//
//                InputStream inputStream = blob.getBinaryStream();
//                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//                byte[] buffer = new byte[4096];
//                int bytesRead = -1;
//
//                while ((bytesRead = inputStream.read(buffer)) != -1) {
//                    outputStream.write(buffer, 0, bytesRead);
//                }
//
//                byte[] imageBytes = outputStream.toByteArray();
//                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
//
//
//                inputStream.close();
//                outputStream.close();
//
////                book.setTitle(title);
////                book.setAuthor(author);
//                car.setPhoto(base64Image);
//            }
//
//        } catch (SQLException | IOException ex) {
//            ex.printStackTrace();
//            throw ex;
//        }
//
//        return car;
//    }
}
