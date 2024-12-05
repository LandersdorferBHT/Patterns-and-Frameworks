package com.schmidt_landersdorfer.AI_Translation_Management.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "translation_models")
public class TranslationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelName;
    private String description;
    private String version;
    private Date creationDate;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private ExternalService service;

    @OneToMany(mappedBy = "translationModel", cascade = CascadeType.ALL)
    private List<Performance> performance;

    @OneToMany(mappedBy = "translationModel", cascade = CascadeType.All)
    private List<ConfigParameter> configurationParameters;

    @OneToMany(mappedBy = "translationModel", cascade = CascadeType.ALL)
    private List<UserFeedback> feedbacks;

    @ManyToMany
    @JoinTable(
            name = "translation_model_texts",
            joinColumns = @JoinColumn(name = "model_id"),
            inverseJoinColumns = @JoinColumn(name = "text_id")
    )

    private List<Text> texts;
}
