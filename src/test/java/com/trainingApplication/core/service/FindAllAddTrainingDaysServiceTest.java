package com.trainingApplication.core.service;

import com.trainingApplication.domain.TrainingDaysEntity;
import com.trainingApplication.dto.TrainingDaysDTO;
import com.trainingApplication.dto.response.FindAllTrainingDaysResponse;
import com.trainingApplication.repository.training_day.TrainingDayRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindAllAddTrainingDaysServiceTest {

    @Mock
    private TrainingDayRepository repository;

    @InjectMocks
    private FindAllTrainingDaysService findAllTrainingDaysService;

    @Test
    void shouldFindAllTrainingDays() {
        var returnResult = entities();
        when(repository.findAll()).thenReturn(returnResult);

        var result = findAllTrainingDaysService.findAll();
        var expectedResult = response();

        assertEquals(expectedResult, result);
    }

    private List<TrainingDaysEntity> entities() {
        var entity = new TrainingDaysEntity();
        entity.setId(1L);
        entity.setUserId(1L);
        entity.setDescription("Test description");
        entity.setTrainingDay("20/03/2022");
        return List.of(entity);
    }

    private FindAllTrainingDaysResponse response() {
        var dto = new TrainingDaysDTO(1L, 1L, "Test description", "20/03/2022");
        return new FindAllTrainingDaysResponse((List.of(dto)));
    }
}
