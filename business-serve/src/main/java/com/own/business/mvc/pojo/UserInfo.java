package com.own.business.mvc.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfo implements Serializable {
    private Long id;

    private String username;

    private Integer age;

    public UserInfo(Long id, String name) {
        this.id = id;
        this.username = name;
    }

    public UserInfo() {
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
