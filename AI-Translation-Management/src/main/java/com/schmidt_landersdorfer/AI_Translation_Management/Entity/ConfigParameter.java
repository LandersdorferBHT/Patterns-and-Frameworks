package com.schmidt_landersdorfer.AI_Translation_Management.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "config_parameters")
public class ConfigParameter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String parameterName;
    private int parameterValue;
    private String description;

    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false)
    private TranslationModel translationModel;
}
