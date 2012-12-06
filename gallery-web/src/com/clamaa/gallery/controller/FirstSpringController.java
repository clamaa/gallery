package com.clamaa.gallery.controller;

import com.clamaa.gallery.entity.User;
import com.clamaa.gallery.services.UserServices;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * @author Clark Ma
 *         created at 11/22/12
 */
@Controller
@RequestMapping("/login.do")
public class FirstSpringController  {

    private Logger logger = Logger.getLogger(getClass());

    @Autowired
    private UserServices userServices;
//    private DataSource dataSource;
//
//    public DataSource getDataSource() {
//        return dataSource;
//    }
//
//    public void setDataSource(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    public UserServices getUserServices() {
        return userServices;
    }

    public void setUserServices(UserServices userServices) {
        this.userServices = userServices;
    }

    @RequestMapping
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws
                                                                                                           Exception {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean success = getUserServices().validateUser(new User(username, password));
        return success ? new ModelAndView("success") : new ModelAndView("fail");
    }
}
