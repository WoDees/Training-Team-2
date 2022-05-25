package com.trainingApplication.controller;

import com.trainingApplication.core.service.AddUserService;
import com.trainingApplication.core.service.DeleteUserService;
import com.trainingApplication.core.service.FindAllUserService;
import com.trainingApplication.core.service.FindUserByIdService;
import com.trainingApplication.dto.request.AddUserRequest;
import com.trainingApplication.dto.response.AddUserResponse;
import com.trainingApplication.dto.response.FindAllUserResponse;
import com.trainingApplication.dto.response.FindByIdUserResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@AllArgsConstructor
public class UserController {

    private final FindAllUserService findAllUserService;
    private final AddUserService addUserService;
    private final DeleteUserService deleteUserService;
    private final FindUserByIdService findUserByIdService;

    @GetMapping("/users")
    public FindAllUserResponse findAll() {
        return findAllUserService.findAll();
    }

    @PostMapping("/users")
    public AddUserResponse add(@RequestBody @Valid AddUserRequest addUserRequest) {
        return addUserService.add(addUserRequest);
    }

    @GetMapping("/users/{id}")
    public FindByIdUserResponse findById(@PathVariable("id") Long id) {
        return findUserByIdService.getById(id);
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable("id") @Valid Long id) {
        deleteUserService.remove(id);
    }
}
