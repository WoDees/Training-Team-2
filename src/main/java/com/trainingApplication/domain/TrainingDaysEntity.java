package com.trainingApplication.domain;

import lombok.Data;

@Data
public class TrainingDaysEntity {

    private Long id;
    private Long userId;
    private String description;
    private String trainingDate;
}