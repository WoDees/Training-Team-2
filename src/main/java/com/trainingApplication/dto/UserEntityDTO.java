package com.trainingApplication.dto;

import com.trainingApplication.domain.TrainingDaysEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntityDTO {

    private Long userId;
    private String nickname;
    private String password;
    private String mail;
    private boolean onlineStatus;
}
