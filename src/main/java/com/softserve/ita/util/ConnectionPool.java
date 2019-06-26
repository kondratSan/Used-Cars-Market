package com.softserve.ita.util;


import static com.softserve.ita.util.Constants.DatabaseInfo.*;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class ConnectionPool {

    private static final Logger logger = LoggerFactory.getLogger(ConnectionPool.class);

    private static final HikariConfig config = new HikariConfig();
    private static HikariDataSource ds = null;

    static {
        try {

            Class.forName(JDBC_DRIVER.getValue());

            config.setJdbcUrl(JDBC_URL.getValue());
            config.setUsername(JDBC_USER_NAME.getValue());
            config.setPassword(JDBC_PASSWORD.getValue());

            config.addDataSourceProperty("cachePrepStmts", "true");
            config.addDataSourceProperty("prepStmtCacheSize", "250");
            config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

            ds = new HikariDataSource(config);

        }catch (ClassNotFoundException e){
            logger.error("Cannot found jdbc driver", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    private ConnectionPool(){}
}
