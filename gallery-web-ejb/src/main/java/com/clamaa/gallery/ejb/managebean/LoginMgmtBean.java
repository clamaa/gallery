package com.clamaa.gallery.ejb.managebean;

import com.clamaa.gallery.ejb.entity.User;
import com.clamaa.gallery.ejb.services.IUserLoginService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author Clark Ma
 *         created at 12/6/12
 */
@ManagedBean
@ViewScoped
public class LoginMgmtBean {

    private String userName;
    private String password;

    @EJB
    private IUserLoginService userLoginService;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login(){
        User user = new User();
        user.setUsername(userName);
        user.setPassword(password);
        boolean success = userLoginService.validateUser(user);
        return success ? "/success.xhtml" : "/fail.xhtml";
    }
}
