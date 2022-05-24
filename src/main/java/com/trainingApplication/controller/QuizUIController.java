package com.trainingApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ui")
public class QuizUIController {

    @GetMapping("/quizzes")
    public String findAllQuizzes() {
        return "/quizzes";
    }
}
