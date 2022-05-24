package com.trainingApplication.dto.response;

import com.trainingApplication.dto.TrainingDaysDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FindAllTrainingDaysResponse {

    private List<TrainingDaysDTO> trainingDaysDTOS;
}
