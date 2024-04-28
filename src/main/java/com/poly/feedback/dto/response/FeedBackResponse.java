package com.poly.feedback.dto.response;

import com.poly.feedback.entity.FeedBack;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Set;

@Getter
@Setter
public class FeedBackResponse {

    private Long id;

    private Timestamp createdDate;

    private Float rating;

    private Integer numLike;

    private Integer numDisLike;

    private String content;

    private String email;

    private FeedBack feedback;

    private Set<FeedBack> feedbackChild;

}
