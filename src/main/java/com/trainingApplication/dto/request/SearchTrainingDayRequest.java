package com.trainingApplication.dto.request;

import lombok.Value;

@Value
public class SearchTrainingDayRequest {

    String description;
    String trainingDay;
    Long userId;
}
