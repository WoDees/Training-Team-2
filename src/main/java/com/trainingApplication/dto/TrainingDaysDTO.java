package com.trainingApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainingDaysDTO {

    private Long id;
    private Long userId;
    private String description;
    private String trainingDate;
}
