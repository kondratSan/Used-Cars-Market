package com.softserve.ita.util;

import org.slf4j.*;

import java.sql.*;

public class DBUtil {
    private static final Logger logger = LoggerFactory.getLogger(DBUtil.class);

    public static void closeStatement(Statement s) {
        try {
            if (s != null) {
                s.close();
            }
        } catch (SQLException e) {
            logger.warn("Cannot close prepare statement", e.getMessage());
        }
    }

    public static void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            logger.warn("Cannot close result set", e.getMessage());
        }
    }


    public static void freeConnection(Connection c) {
        try {
            if(c != null){
                c.close();
            }
        } catch (SQLException e) {
            logger.error("Cannot close connection!", e.getMessage());
        }
    }


    public static void transactionRollBackHandler(Connection conn){

        if(conn != null){
            try {
                logger.warn("Transaction is being rolled back");
                conn.rollback();
                conn.setAutoCommit(true);
            }catch (SQLException sqlEx){
                logger.error(sqlEx.getMessage(), sqlEx);
            }
        }
    }
}
