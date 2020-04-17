package com.tanyu.simplemall.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private Long id = 0L;

    private String nickName;

    private String password;

    private String salt;

    private String head;

    private Date registerTime;

    private Date lastLoginDate;

    private Integer loginCount;

}
