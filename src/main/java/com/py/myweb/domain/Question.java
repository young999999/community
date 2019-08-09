package com.py.myweb.domain;

public class Question {
    private Integer id;
    private String title;
    private String  description;
    private Long gmtcreat;
    private Long gmtmodified;
    private Integer creator;
    private String tag;
    private Integer viewcount;
    private Integer coommentcount;
    private Integer likecount;

    public Question() {
        super();
    }

    public Question(Integer id, String title, String description, Long gmtcreat, Long gmtmodified, Integer creator, String tag, Integer viewcount, Integer coommentcount, Integer likecount) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.gmtcreat = gmtcreat;
        this.gmtmodified = gmtmodified;
        this.creator = creator;
        this.tag = tag;
        this.viewcount = viewcount;
        this.coommentcount = coommentcount;
        this.likecount = likecount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getGmtcreat() {
        return gmtcreat;
    }

    public void setGmtcreat(Long gmtcreat) {
        this.gmtcreat = gmtcreat;
    }

    public Long getGmtmodified() {
        return gmtmodified;
    }

    public void setGmtmodified(Long gmtmodified) {
        this.gmtmodified = gmtmodified;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getViewcount() {
        return viewcount;
    }

    public void setViewcount(Integer viewcount) {
        this.viewcount = viewcount;
    }

    public Integer getCoommentcount() {
        return coommentcount;
    }

    public void setCoommentcount(Integer coommentcount) {
        this.coommentcount = coommentcount;
    }

    public Integer getLikecount() {
        return likecount;
    }

    public void setLikecount(Integer likecount) {
        this.likecount = likecount;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", gmtcreat=" + gmtcreat +
                ", gmtmodified=" + gmtmodified +
                ", creator=" + creator +
                ", tag='" + tag + '\'' +
                ", viewcount=" + viewcount +
                ", coommentcount=" + coommentcount +
                ", likecount=" + likecount +
                '}';
    }
}
