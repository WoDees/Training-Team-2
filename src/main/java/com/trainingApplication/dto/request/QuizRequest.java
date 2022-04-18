package com.trainingApplication.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QuizRequest {

    private Long gender;
    private Long age;
    private Long weight;
    private Long growth;
    private Long desiredWeight;
    private String target;
    private Long userId;
}
