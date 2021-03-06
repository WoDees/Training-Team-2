package com.trainingApplication.dto.response;

import com.trainingApplication.core.validation.CoreError;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class AddTrainingDaysResponse {

    private Long createdTrainingDaysId;
    private List<CoreError> errors;
}
