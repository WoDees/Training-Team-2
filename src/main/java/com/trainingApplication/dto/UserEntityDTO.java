package com.trainingApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntityDTO {

    private Long userId;
    private String nickname;
    private String password;
    private String mail;
    private boolean onlineStatus;
    private Long trainingDaysCount;
}
