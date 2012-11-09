package com.clamaa.gallery.entity;

import javax.persistence.*;

/**
 * @author Clark Ma
 *         created at 11/8/12
 */
@Entity
@Table(name = "usertable")
public class User {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
