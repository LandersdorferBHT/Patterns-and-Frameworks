package com.schmidt_landersdorfer.AI_Translation_Management.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "external_services")
public class ExternalService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String serviceName;
    private String apiEndpoint;
    private String contactInformation;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private List<TranslationModel> translationModels;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private List<DataProvider> dataProviders;
}
