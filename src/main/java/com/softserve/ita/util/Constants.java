package com.softserve.ita.util;

public class Constants {

    public static final String ADMIN = "admin";
    public static final String USER = "user";
    public static final String UNLOGGED = "unlogged";


    enum DatabaseInfo {

        JDBC_DRIVER("com.mysql.cj.jdbc.Driver"),
        JDBC_URL("jdbc:mysql://localhost:3306/usedcarsmarket?useSSL=false&serverTimezone=UTC"),
        JDBC_USER_NAME("root"),
        JDBC_PASSWORD("root");

        private String value;

        DatabaseInfo(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
