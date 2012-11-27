package com.clamaa.gallery.ejb.services.impl;

import com.clamaa.gallery.ejb.entity.User;
import com.clamaa.gallery.ejb.services.IUserLoginService;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * @author Clark Ma
 *         created at 11/13/12
 */
@Stateless
public class UserLoginService implements IUserLoginService {

    @PersistenceContext(unitName = "clamaa")
    private EntityManager em;

    @Override
    public boolean validateUser(User user) {
        Query namedQuery = em.createNamedQuery("getUserByNameAndPassword");
        namedQuery.setParameter("username", user.getUsername());
        namedQuery.setParameter("password", user.getPassword());
        return namedQuery.getResultList().size() == 1;
    }
}
