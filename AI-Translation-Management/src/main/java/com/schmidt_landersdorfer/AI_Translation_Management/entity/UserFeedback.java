package com.schmidt_landersdorfer.AI_Translation_Management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class to represent the feedback provided by a user
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "feedbacks")
public class UserFeedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int rating;
    private String userComment;
    private Date feedbackDate;

    public UserFeedback(int rating, String userComment) {
        this.rating = rating;
        this.userComment = userComment;
        this.feedbackDate = new Date();
    }
}