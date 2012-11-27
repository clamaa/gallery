package com.clamaa.gallery.ejb.services;

import com.clamaa.gallery.ejb.entity.User;

/**
 * @author Clark Ma
 *         created at 11/27/12
 */
public interface IUserLoginService {

    boolean validateUser(User user);

}
