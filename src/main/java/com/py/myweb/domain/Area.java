package com.py.myweb.domain;

import java.util.Date;

public class Area {
    private Integer id;
    private String name;
    private Integer priority;
    private Date creatTime;
    private Date lastEditCreat;

    public Area() {
        super();
    }

    public Area(Integer id, String name, Integer priority, Date creatTime, Date lastEditCreat) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.creatTime = creatTime;
        this.lastEditCreat = lastEditCreat;
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

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getLastEditCreat() {
        return lastEditCreat;
    }

    public void setLastEditCreat(Date lastEditCreat) {
        this.lastEditCreat = lastEditCreat;
    }

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", priority=" + priority +
                ", creatTime=" + creatTime +
                ", lastEditCreat=" + lastEditCreat +
                '}';
    }
}
