package com.RCDancer.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_detail")
public class UserDetail {
    private String username;

    private String name;

    private String sex;

    @Column(name = "join_date")
    private Date joinDate;

    private String aventor;

    private String email;

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return join_date
     */
    public Date getJoinDate() {
        return joinDate;
    }

    /**
     * @param joinDate
     */
    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    /**
     * @return aventor
     */
    public String getAventor() {
        return aventor;
    }

    /**
     * @param aventor
     */
    public void setAventor(String aventor) {
        this.aventor = aventor;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
}