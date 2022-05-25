package com.trainingApplication.core.service;

import com.trainingApplication.domain.QuizEntity;
import com.trainingApplication.dto.QuizEntityDTO;
import com.trainingApplication.dto.response.FindAllQuizzesResponse;
import com.trainingApplication.repository.quiz.QuizRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FindAllQuizzesService {

    private final QuizRepository repository;

    public FindAllQuizzesResponse findAll() {
        var dtos = repository.findAll().stream()
                .map(this::convert)
                .collect(Collectors.toList());
        return new FindAllQuizzesResponse(dtos);
    }

    private QuizEntityDTO convert(QuizEntity entity) {
        return new QuizEntityDTO(entity.getId(), entity.getGender(), entity.getAge(), entity.getWeight(),
                entity.getGrowth(), entity.getDesiredWeight(), entity.getUserId(), entity.getTarget());
    }
}
