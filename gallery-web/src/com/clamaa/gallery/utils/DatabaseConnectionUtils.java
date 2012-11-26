package com.clamaa.gallery.utils;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
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
//            Class.forName("org.postgresql.Driver").newInstance();
//            String url ="jdbc:postgresql://localhost/postgres";
//            String user="postgres";
//            String password="postgres";
//            connection = DriverManager.getConnection(url, user, password);

            Context context = new InitialContext();
            Context envContext = (Context)context.lookup("java:/comp/env");
            DataSource dataSource = (DataSource) envContext.lookup("dataSourceJndi");
            connection = dataSource.getConnection();
//        } catch (InstantiationException e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//        } catch (SQLException e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (NamingException e) {
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
