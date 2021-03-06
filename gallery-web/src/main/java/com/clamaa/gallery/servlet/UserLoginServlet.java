package com.clamaa.gallery.servlet;

import com.clamaa.gallery.entity.User;
import com.clamaa.gallery.services.UserServices;
import com.clamaa.gallery.utils.DatabaseConnectionUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Clark Ma
 *         created at 11/9/12
 */
public class UserLoginServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
                                                                           ServletException,
                                                                               IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
                                                                            ServletException,
                                                                            IOException {
//        String userName = req.getParameter("username");
//        String password = req.getParameter("password");
//        UserServices userServices = new UserServices();
//        boolean result = userServices.validateUser(new User(userName, password));
//        System.out.println(result);
        DatabaseConnectionUtils.getInstance();
    }
}
