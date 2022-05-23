package com.trainingApplication.controller;

import com.trainingApplication.core.service.*;
import com.trainingApplication.dto.request.AddUserRequest;
import com.trainingApplication.dto.response.AddUserResponse;
import com.trainingApplication.dto.response.FindAllUserResponse;
import com.trainingApplication.dto.response.FindByIdUserResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
public class UserController {

    private final FindAllUserService findAllUserService;
    private final AddUserService addUserService;
    private final RemoveUserService removeUserService;
    private final FindUserByIdService findUserByIdService;

    @GetMapping("/users")
    public FindAllUserResponse findAll() {
        return findAllUserService.findAll();
    }

    @PostMapping("/users")
    public AddUserResponse add(@RequestBody AddUserRequest addUserRequest) {
        return addUserService.add(addUserRequest);
    }

    @GetMapping("/users/{id}")
    public FindByIdUserResponse findUser(@PathVariable("id") Long id) {
        return findUserByIdService.getById(id);
    }

}
