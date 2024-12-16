package com.schmidt_landersdorfer.AI_Translation_Management.controller;

import com.schmidt_landersdorfer.AI_Translation_Management.entity.ModelConfigurationParameter;
import com.schmidt_landersdorfer.AI_Translation_Management.service.ModelConfigurationParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/model-configuration-parameters")
public class ModelConfigurationParameterController {

    private final ModelConfigurationParameterService parameterService;

    @Autowired
    public ModelConfigurationParameterController(ModelConfigurationParameterService parameterService) {
        this.parameterService = parameterService;
    }

    // Get all configuration parameters
    @GetMapping
    public ResponseEntity<List<ModelConfigurationParameter>> getAllParameters() {
        List<ModelConfigurationParameter> parameters = parameterService.getAllParameters();
        return ResponseEntity.ok(parameters);
    }

    // Get a single configuration parameter by ID
    @GetMapping("/{id}")
    public ResponseEntity<ModelConfigurationParameter> getParameterById(@PathVariable Long id) {
        ModelConfigurationParameter parameter = parameterService.getParameterById(id);
        return ResponseEntity.ok(parameter);
    }

    // Create a new configuration parameter
    @PostMapping
    public ResponseEntity<ModelConfigurationParameter> createParameter(@RequestBody ModelConfigurationParameter parameter) {
        ModelConfigurationParameter createdParameter = parameterService.createParameter(parameter);
        return ResponseEntity.ok(createdParameter);
    }

    // Update an existing configuration parameter
    @PutMapping("/{id}")
    public ResponseEntity<ModelConfigurationParameter> updateParameter(
            @PathVariable Long id,
            @RequestBody ModelConfigurationParameter parameter) {
        ModelConfigurationParameter updatedParameter = parameterService.updateParameter(id, parameter);
        return ResponseEntity.ok(updatedParameter);
    }

    // Delete a configuration parameter
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParameter(@PathVariable Long id) {
        parameterService.deleteParameter(id);
        return ResponseEntity.noContent().build();
    }
}