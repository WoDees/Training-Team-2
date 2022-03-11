package com.trainingApplication.dto.request;

import lombok.Data;

@Data
public class LogOutUserRequest {

    private Long userId;
    private boolean onlineStatus;

}
