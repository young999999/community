package com.py.myweb.domain;

public class User {
    private Integer id;
    private String name;
    private String accountID;
    private String token;
    private Long gmtCreat;
    private Long gmtModified;

    public User() {
        super();
    }

    public User(Integer id, String name, String accountID, String token, Long gmtCreat, Long gmtModified) {
        this.id = id;
        this.name = name;
        this.accountID = accountID;
        this.token = token;
        this.gmtCreat = gmtCreat;
        this.gmtModified = gmtModified;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getGmtCreat() {
        return gmtCreat;
    }

    public void setGmtCreat(Long gmtCreat) {
        this.gmtCreat = gmtCreat;
    }

    public Long getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", accountID='" + accountID + '\'' +
                ", token='" + token + '\'' +
                ", gmtCreat=" + gmtCreat +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
