package com.trainingApplication.dto.response;

import com.trainingApplication.core.validation.CoreError;
import lombok.Data;

import java.util.List;

@Data
public class AddUserResponse {

    private Long createdUserId;
    private List<CoreError>errors;
    private boolean onlineStatus;

}
