package com.py.myweb.dto;

import com.py.myweb.domain.User;
import lombok.Data;

@Data
public class QuestionDTO {
    private Integer id;
    private String title;
    private String  description;
    private Long gmtcreat;
    private Long gmtmodified;
    private Integer creator;
    private String tag;
    private Integer viewcount;
    private Integer commentcount;
    private Integer likecount;
    private User user;
}
