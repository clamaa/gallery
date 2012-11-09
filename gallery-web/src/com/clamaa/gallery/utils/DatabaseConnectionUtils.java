package com.clamaa.gallery.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Clark Ma
 *         created at 11/8/12
 */
public class DatabaseConnectionUtils {

    private Connection connection;

    private static DatabaseConnectionUtils instance;

    private DatabaseConnectionUtils(){
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            String url ="jdbc:postgresql://localhost/postgres";
            String user="postgres";
            String password="postgres";
            connection = DriverManager.getConnection(url, user, password);
        } catch (InstantiationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public static DatabaseConnectionUtils getInstance(){
        if(instance == null){
            instance = new DatabaseConnectionUtils();
        }
        return instance;
    }

    public Connection getConnection(){
        return connection;
    }

}
