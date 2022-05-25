package com.trainingApplication.controller;

import com.trainingApplication.core.service.AddQuizService;
import com.trainingApplication.core.service.FindAllQuizzesService;
import com.trainingApplication.dto.request.AddQuizRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/ui")
public class QuizUIController {

    private final AddQuizService addQuizService;
    private final FindAllQuizzesService findAllQuizzesService;

    @GetMapping("/findAllQuizzes")
    public String findAllQuizzes(Model model) {
        var response = findAllQuizzesService.findAll();
        model.addAttribute("quizzes", response.getQuizEntityDTOS());
        return "/findAllQuizzes";
    }

    @GetMapping("/addQuiz")
    public String addQuizView(Model model) {
        model.addAttribute("quiz", new AddQuizRequest());
        return "addQuiz";
    }

    @PostMapping("/addQuiz")
    public String addQuizzes(@ModelAttribute AddQuizRequest quiz) {
        addQuizService.addQuiz(quiz);
        return "redirect:/ui/findAllQuizzes";
    }
}
