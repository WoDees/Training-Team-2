package com.trainingApplication.dto.response;

import com.trainingApplication.dto.TrainingDaysDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindByIdTrainingDaysResponse {

    private TrainingDaysDTO trainingDays;
}
