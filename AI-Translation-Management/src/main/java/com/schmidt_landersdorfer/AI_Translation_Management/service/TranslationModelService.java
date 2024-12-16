package com.schmidt_landersdorfer.AI_Translation_Management.service;

import com.schmidt_landersdorfer.AI_Translation_Management.entity.TranslationModel;
import com.schmidt_landersdorfer.AI_Translation_Management.repository.TranslationModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TranslationModelService {

    private final TranslationModelRepository translationModelRepository;

    // Konstruktorinjektion für das Repository
    @Autowired
    public TranslationModelService(TranslationModelRepository translationModelRepository) {
        this.translationModelRepository = translationModelRepository;
    }

    // Methode, um alle Übersetzungsmodelle abzurufen
    public List<TranslationModel> getAllTranslationModels() {
        return translationModelRepository.findAll();
    }

    // Methode, um ein Übersetzungsmodell nach ID abzurufen
    public Optional<TranslationModel> getTranslationModelById(Long id) {
        return translationModelRepository.findById(id);
    }

    // Methode, um ein neues Übersetzungsmodell zu erstellen
    public TranslationModel createTranslationModel(TranslationModel translationModel) {
        return translationModelRepository.save(translationModel);
    }

    // Methode, um ein bestehendes Übersetzungsmodell zu aktualisieren
    public TranslationModel updateTranslationModel(Long id, TranslationModel translationModel) {
        if (translationModelRepository.existsById(id)) {
            translationModel.setId(id);  // Die ID muss gesetzt werden, damit das Modell korrekt gespeichert wird
            return translationModelRepository.save(translationModel);
        } else {
            return null;  // Modell existiert nicht
        }
    }

    // Methode, um ein Übersetzungsmodell zu löschen
    public boolean deleteTranslationModel(Long id) {
        if (translationModelRepository.existsById(id)) {
            translationModelRepository.deleteById(id);
            return true;  // Erfolgreiches Löschen
        } else {
            return false;  // Modell existiert nicht
        }
    }
}