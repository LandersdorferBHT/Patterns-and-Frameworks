package com.schmidt_landersdorfer.AI_Translation_Management.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "performances")
public class Performance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String metricName;
    private float value;
    private Date evaluationDate;
    private String reviewComment;

    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false)
    private TranslationModel translationModel;
}
