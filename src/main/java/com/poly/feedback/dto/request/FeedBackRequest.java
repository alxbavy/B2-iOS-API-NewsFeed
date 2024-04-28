package com.poly.feedback.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FeedBackRequest {

    private Float rating;

    private String content;

    private Long feedBackParentId;

    private Long productId;

}
