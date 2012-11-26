package com.clamaa.gallery.contoller;

import com.clamaa.gallery.entity.User;
import com.clamaa.gallery.services.UserServices;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Clark Ma
 *         created at 11/22/12
 */
public class FirstSpringController extends AbstractController {

    private Logger logger = Logger.getLogger(getClass());

    private UserServices userServices;

    public UserServices getUserServices() {
        return userServices;
    }

    public void setUserServices(UserServices userServices) {
        this.userServices = userServices;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws
                                                                                                           Exception {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean success = getUserServices().validateUser(new User(username, password));
        return success ? new ModelAndView("success") : new ModelAndView("fail");
    }
}
