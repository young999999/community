package com.py.myweb.domain;

import lombok.Data;

@Data
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

}
