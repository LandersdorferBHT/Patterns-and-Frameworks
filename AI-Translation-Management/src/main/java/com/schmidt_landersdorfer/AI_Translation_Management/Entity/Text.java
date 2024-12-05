package com.schmidt_landersdorfer.AI_Translation_Management.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "texts")
public class Text {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dataSetName;
    private String sourceLanguage;
    private int fileSize;
    private String description;

    @ManyToOne
    @JoinColumn(name = "data_provider_id", nullable = false)
    private DataProvider dataProvider;

    @ManyToMany(mappedBy = "texts")
    private List<TranslationModel> translationModels;
}
