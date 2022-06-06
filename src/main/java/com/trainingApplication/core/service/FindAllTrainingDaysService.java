package com.trainingApplication.core.service;

import com.trainingApplication.domain.TrainingDaysEntity;
import com.trainingApplication.dto.TrainingDaysDTO;
import com.trainingApplication.dto.request.SearchTrainingDayRequest;
import com.trainingApplication.repository.training_day.TrainingDayRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FindAllTrainingDaysService {

    private final TrainingDayRepository repository;

    public List<TrainingDaysDTO> findAllBy(SearchTrainingDayRequest request) {
        var specifications = getSearchSpecifications(request);
        var entities = specifications.stream()
                .reduce(Specification::and)
                .map(repository::findAll)
                .orElseGet(repository::findAll);

        return entities.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    private List<Specification<TrainingDaysEntity>> getSearchSpecifications(SearchTrainingDayRequest request) {
        var specifications = new ArrayList<Specification<TrainingDaysEntity>>();
        var trainingDate = request.getTrainingDate();
        var description = request.getDescription();
        var userId = request.getUserId();

        if (trainingDate != null) {
            var specification2 = new SearchTrainingDayByTrainingDateSpecification(trainingDate);
            specifications.add(specification2);
        }
        if (description != null) {
            specifications.add(new SearchTrainingDayByDescriptionSpecification(description));
        }
        if (userId != null) {
            specifications.add(new SearchTrainingDayByUserIdSpecification(userId));
        }
        return specifications;
    }

    public List<TrainingDaysDTO> findAll() {
        return repository.findAll().stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    private TrainingDaysDTO convert(TrainingDaysEntity entity) {
        return new TrainingDaysDTO(entity.getId(), entity.getUserId(), entity.getDescription(), entity.getTrainingDate());
    }
}
