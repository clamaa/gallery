package com.clamaa.gallery;

import com.clamaa.gallery.entity.User;
import com.clamaa.gallery.utils.DatabaseConnectionUtils;
import com.clamaa.gallery.utils.HibernateUtils;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Clark Ma
 *         created at 11/8/12
 */
public class Test extends HttpServlet {

    private Logger logger = Logger.getLogger(getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
                                                                           ServletException,
                                                                           IOException {
        logger.error("doget method invoke");
//        Connection connection = DatabaseConnectionUtils.getInstance().getConnection();
//        Statement stmt = null;
//        try {
//            stmt = connection.createStatement();
//            ResultSet resultSet = stmt.executeQuery("select * from user");
//            while (resultSet.next()){
////                resultSet.getInt(0);
////                resultSet.getInt(1);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//        }

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        User user = (User)session.get(User.class, 20l);
        System.out.print(String.format("username=%s, password=%s", user.getUsername(), user.getPassword()));

        HibernateUtils.shutDown();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
                                                                            ServletException,
                                                                            IOException {
        logger.error("dopost method invoke");
    }
}
