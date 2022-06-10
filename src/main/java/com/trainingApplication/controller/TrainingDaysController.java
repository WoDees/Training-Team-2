package com.trainingApplication.controller;

import com.trainingApplication.core.service.FindAllTrainingDaysService;
import com.trainingApplication.core.service.FindByIdTrainingDaysService;
import com.trainingApplication.core.service.AddTrainingDaysService;
import com.trainingApplication.dto.TrainingDaysDTO;
import com.trainingApplication.dto.request.AddTrainingDaysRequest;
import com.trainingApplication.dto.request.SearchTrainingDayRequest;
import com.trainingApplication.dto.response.AddTrainingDaysResponse;
import com.trainingApplication.dto.response.FindByIdTrainingDaysResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/training_days")
@AllArgsConstructor
public class TrainingDaysController {

    private final AddTrainingDaysService addTrainingDaysService;
    private final FindAllTrainingDaysService findAllTrainingDaysService;
    private final FindByIdTrainingDaysService findByIdTrainingDaysService;

    @PostMapping
    public AddTrainingDaysResponse add(@RequestBody @Valid AddTrainingDaysRequest request) {
        return addTrainingDaysService.add(request);
    }

    @GetMapping
    public List<TrainingDaysDTO> findAll(@RequestParam(required = false) String trainingDay,
                                         @RequestParam(required = false) String description,
                                         @RequestParam(required = false) Long userId) {
        var request = new SearchTrainingDayRequest(trainingDay, description, userId);
        return findAllTrainingDaysService.findAllBy(request);
    }

    @GetMapping("/{id}")
    public FindByIdTrainingDaysResponse findById(@PathVariable("id") Long id) {
        return findByIdTrainingDaysService.getById(id);
    }
}
