package com.own.userserve.mvc.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfo implements Serializable {
    private Long id;

    private String username;

    private Integer age;
}
