package com.py.myweb.domain;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private String accountID;
    private String token;
    private Long gmtCreat;
    private Long gmtModified;
    private String avatarurl;
}
