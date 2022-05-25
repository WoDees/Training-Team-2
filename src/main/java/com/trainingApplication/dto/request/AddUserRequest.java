package com.trainingApplication.dto.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class AddUserRequest {

    @NotNull
    @NotBlank
    @Length(min = 5, max = 12)
    private String nickname;
    @NotNull
    @NotBlank
    @Length(min = 1, max = 64)
    private String mail;
    @NotNull
    @NotBlank
    @Length(min = 6, max = 14)
    private String password;

}