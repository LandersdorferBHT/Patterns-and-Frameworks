package com.schmidt_landersdorfer.AI_Translation_Management.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "data_providers")
public class DataProvider {

    @id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String providerName;
    private String url;
    private String providerDescription;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private ExternalService externalService;

    @OneToMany(mappedBy = "dataProvider", cascade = CascadeType.ALL)
    private List<Text> texts;
}
