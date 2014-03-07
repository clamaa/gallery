package com.baobaotao.web;

import com.baobaotao.domain.User;
import com.baobaotao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * User: mazhqa
 * Date: 14-3-7
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/reg.html")
    public String register(){
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView createUser(User user){
        userService.createUser(user);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("createSuccess");
        mav.addObject("user", user);
        return mav;
    }

}
