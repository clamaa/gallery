package com.clamaa.gallery.ejb.services;

import com.clamaa.gallery.ejb.entity.User;

import javax.ejb.Local;

/**
 * @author Clark Ma
 *         created at 11/27/12
 */
@Local
public interface IUserLoginService {

    boolean validateUser(User user);

}
