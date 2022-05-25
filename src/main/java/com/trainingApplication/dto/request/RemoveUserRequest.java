package com.trainingApplication.dto.request;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class RemoveUserRequest {

    @NotNull
    @Min(1)
    private Long id;

}
