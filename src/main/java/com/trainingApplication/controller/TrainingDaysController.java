package com.trainingApplication.controller;

import com.trainingApplication.core.service.FindAllTrainingDaysService;
import com.trainingApplication.core.service.FindByIdTrainingDaysService;
import com.trainingApplication.core.service.AddTrainingDaysService;
import com.trainingApplication.dto.request.AddTrainingDaysRequest;
import com.trainingApplication.dto.response.AddTrainingDaysResponse;
import com.trainingApplication.dto.response.FindAllTrainingDaysResponse;
import com.trainingApplication.dto.response.FindByIdTrainingDaysResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@AllArgsConstructor
public class TrainingDaysController {

    private final AddTrainingDaysService addTrainingDaysService;
    private final FindAllTrainingDaysService findAllTrainingDaysService;
    private final FindByIdTrainingDaysService findByIdTrainingDaysService;

    @PostMapping("/training_days")
    public AddTrainingDaysResponse add(@RequestBody @Valid AddTrainingDaysRequest request) {
        return addTrainingDaysService.add(request);
    }

    @GetMapping("/training_days")
    public FindAllTrainingDaysResponse findAll() {
        return findAllTrainingDaysService.findAll();
    }

    @GetMapping("/training_days/{id}")
    public FindByIdTrainingDaysResponse findById(@PathVariable("id") Long id) {
        return findByIdTrainingDaysService.getById(id);
    }
}
