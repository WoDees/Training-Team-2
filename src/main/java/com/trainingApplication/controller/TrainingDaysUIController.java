package com.trainingApplication.controller;

import com.trainingApplication.core.service.AddTrainingDaysService;
import com.trainingApplication.core.service.FindAllTrainingDaysService;
import com.trainingApplication.dto.request.AddTrainingDaysRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping("/ui")
public class TrainingDaysUIController {

    private final FindAllTrainingDaysService findAllTrainingDaysService;
    private final AddTrainingDaysService addTrainingDaysService;

    @GetMapping("/findAllTrainingDays")
    public String findAllTrainingDays(Model model) {
        var response = findAllTrainingDaysService.findAll();
        model.addAttribute("days", response);
        return "findAllTrainingDays";
    }

    @GetMapping("/addTrainingDay")
    public String addDayView(Model model) {
        model.addAttribute("day", new AddTrainingDaysRequest());
        return "addTrainingDay";
    }

    @PostMapping("/addTrainingDay")
    public String addTrainingDays(@ModelAttribute @Valid AddTrainingDaysRequest day) {
        addTrainingDaysService.add(day);
        return "redirect:/ui/findAllTrainingDays";
    }
}
