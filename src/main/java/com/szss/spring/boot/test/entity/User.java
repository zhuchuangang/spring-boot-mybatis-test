package com.szss.spring.boot.test.entity;

import java.io.Serializable;

/**
 * Created by zcg on 15/12/25.
 */
public class User implements Serializable {
    private Long id;
    private String username;

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
}