package com.trainingApplication.domain;

import lombok.Data;

import java.util.List;

@Data
public class UserEntity {

    private Long userId;
    private String nickname;
    private String password;
    private String mail;
    private boolean onlineStatus;
    private List<TrainingDaysEntity> calendarEntityList;
}
