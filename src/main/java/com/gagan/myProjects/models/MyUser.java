package com.gagan.myProjects.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MyUser {
    @Id
    private String username;
    private String password;
    private  Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public MyUser(String username, String password, Integer age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }

    public MyUser() {
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
