package com.clamaa.gallery.ejb.entity;

import javax.persistence.*;

/**
 * @author Clark Ma
 *         created at 11/27/12
 */
@Entity
@Table(name = "usertable")
@NamedQueries(
        {
                @NamedQuery(name = "getUserByNameAndPassword", query = "select u from User u where u.username=:username and u.password=:password")
        }
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String username;
    @Column
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
