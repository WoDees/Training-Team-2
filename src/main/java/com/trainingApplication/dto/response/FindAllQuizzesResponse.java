package com.trainingApplication.dto.response;

import com.trainingApplication.dto.QuizEntityDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FindAllQuizzesResponse {

    private List<QuizEntityDTO> quizEntityDTOS;
}
