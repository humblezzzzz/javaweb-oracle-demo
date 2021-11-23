package com.chen.web.entity;

/**
 * @author Chenchenx
 * @version 1.0
 * @date 2021/11/18 9:03
 */
public class AdminEntity {
    private Integer aid;
    private String username;
    private String password;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
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
