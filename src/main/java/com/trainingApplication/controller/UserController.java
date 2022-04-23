package com.trainingApplication.controller;

import com.trainingApplication.core.service.FindAllUserService;
import com.trainingApplication.dto.response.FindAllUserResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
public class UserController {

    private final FindAllUserService findAllUserService;

    @GetMapping("/users")
    public FindAllUserResponse findAll() {
        return findAllUserService.findAll();
    }
}
