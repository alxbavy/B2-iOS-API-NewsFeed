package com.poly.feedback.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "feed_back")
@Getter
@Setter
public class FeedBack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private Timestamp createdDate;

    private Float rating;

    private Integer numLike;

    private Integer numDisLike;

    @Column(name = "content_feedback")
    private String content;

    private Long userId;

    @ManyToOne
    @JoinColumn(name = "feed_back_parent" )
    @JsonIgnoreProperties({"feedbackChild"})
    private FeedBack feedback;

    @OneToMany(mappedBy = "feedback",cascade = {CascadeType.REMOVE})
    @JsonIgnoreProperties({""})
    private Set<FeedBack> feedbackChild;
}
