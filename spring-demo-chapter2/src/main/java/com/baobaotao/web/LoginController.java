package com.baobaotao.web;

import com.baobaotao.domain.User;
import com.baobaotao.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * User: clamaa
 * Date: 14-3-2
 */
@Controller
public class LoginController {

    private static Logger logger = Logger.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    /**
     * 负责处理index.html的请求
     *
     * @return
     */
    @RequestMapping(value = "/index.html")
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/loginCheck.html")
    public ModelAndView loginCheck(HttpServletRequest httpServletRequest, LoginCommand loginCommand) {
        boolean isValidUser = userService.hasMatchUser(loginCommand.getUserName(), loginCommand.getPassword());
        if (!isValidUser) {
            return new ModelAndView("login", "error", "user name or password is incorrect");
        } else {
            User user = userService.findUserByUserName(loginCommand.getUserName());
            user.setLastIp(httpServletRequest.getRemoteAddr());
            user.setLastVisit(new Date());
            userService.loginSuccess(user);
            httpServletRequest.getSession().setAttribute("user", user);
            return new ModelAndView("main");
        }
    }


}
