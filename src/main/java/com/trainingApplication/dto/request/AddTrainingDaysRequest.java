package com.trainingApplication.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddTrainingDaysRequest {

    private String eventDate;
    private String description;
}