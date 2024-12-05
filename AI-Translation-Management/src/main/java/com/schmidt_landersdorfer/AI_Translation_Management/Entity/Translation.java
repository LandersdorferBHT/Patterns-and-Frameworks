package com.schmidt_landersdorfer.AI_Translation_Management.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "translations")
public class Translation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dataSetName;
    private String sourceLanguage;
    private String targetLanguage;
    private int fileSize;
    private String description;

    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false)
    private TranslationModel translationModel;

    @OneToMany(mappedBy = "translation", cascade = CascadeType.ALL)
    private List<UserFeedback> userFeedbacks;
}
