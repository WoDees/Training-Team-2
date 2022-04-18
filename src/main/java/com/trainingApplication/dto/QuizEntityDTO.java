package com.trainingApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizEntityDTO {

    private Long id;
    private Long userId;
    private Long gender;
    private Long age;
    private Long weight;
    private Long growth;
    private Long desiredWeight;
    private String target;
}
