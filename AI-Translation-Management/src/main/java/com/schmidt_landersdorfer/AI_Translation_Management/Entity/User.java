package com.schmidt_landersdorfer.AI_Translation_Management.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserFeedback> feedbacks; // Not implemnted yet
    private Long id;

    private String userName;
    private String email;
    private String role;
    private Date registrationDate;

    public User(String userName, String email, String role, Date registrationDate) {
        this.userName = userName;
        this.email = email;
        this.role = role;
        this.registrationDate = registrationDate;
    }

    // Additional Methods
    /*public void addFeedback(Feedback feedback) {
        this.feedbacks.add(feedback);
    }

    public void removeFeedback(Feedback feedback) {
        this.feedbacks.remove(feedback);
    }*/














}
