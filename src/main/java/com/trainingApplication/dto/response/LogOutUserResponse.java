package com.trainingApplication.dto.response;

import lombok.Data;

@Data
public class LogOutUserResponse {

    private Long userId;
    private boolean onlineStatus;

}
