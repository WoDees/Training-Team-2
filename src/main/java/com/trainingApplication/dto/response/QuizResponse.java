package com.trainingApplication.dto.response;

import com.trainingApplication.core.validation.CoreError;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class QuizResponse {

    private Long createdQuizId;
    private List<CoreError> errors;
}
