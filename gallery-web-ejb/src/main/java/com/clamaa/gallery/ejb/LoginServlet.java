package com.clamaa.gallery.ejb;

import com.clamaa.gallery.ejb.entity.User;
import com.clamaa.gallery.ejb.services.IUserLoginService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Clark Ma
 *         created at 11/12/12
 */
@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @EJB
    private IUserLoginService userLoginService;

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

        User user = new User();
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        boolean success = userLoginService.validateUser(user);
        System.out.println(success);
    }

}
