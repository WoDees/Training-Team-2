package com.trainingApplication.controller;

import com.trainingApplication.core.service.AddQuizService;
import com.trainingApplication.dto.request.AddQuizRequest;
import com.trainingApplication.dto.response.AddQuizResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@AllArgsConstructor
public class QuizController {

    private final AddQuizService addQuizService;

    @PostMapping("/quiz")
    public AddQuizResponse add(@RequestBody @Valid AddQuizRequest request) {
        return addQuizService.addQuiz(request);
    }
}
