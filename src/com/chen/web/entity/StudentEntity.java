package com.chen.web.entity;

import java.util.Date;

/**
 * @author Chenchenx
 * @version v1.0
 * @date 2021/11/18 16:20
 */
public class StudentEntity {
    private Integer sdi;
    private String name;
    private String no;
    private Date date;

    public Integer getSdi() {
        return sdi;
    }

    public void setSdi(Integer sdi) {
        this.sdi = sdi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
