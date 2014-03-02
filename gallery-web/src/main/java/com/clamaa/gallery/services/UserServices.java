package com.clamaa.gallery.services;

import com.clamaa.gallery.entity.User;
import com.clamaa.gallery.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Clark Ma
 *         created at 11/9/12
 */
@Service
public class UserServices {

    public boolean validateUser(User user){
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from User ");

        List<User> userList = query.list();
        for (User userInDb : userList) {
            if(userInDb.getUsername().equals(user.getUsername()) && userInDb.getPassword().equals(user.getPassword())){
                return true;
            }
        }
        return false;
    }

}
