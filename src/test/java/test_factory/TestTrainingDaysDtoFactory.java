package test_factory;

import com.trainingApplication.domain.TrainingDaysEntity;
import com.trainingApplication.dto.request.AddTrainingDaysRequest;

public class TestTrainingDaysDtoFactory {

    public static TrainingDaysEntity createEntity(Long id) {
        var entity = new TrainingDaysEntity();
        entity.setId(id);
        entity.setUserId(id);
        entity.setTrainingDay("28/02/2022");
        entity.setDescription("Test description");
        return entity;
    }

    public static AddTrainingDaysRequest createRequest() {
        var request = new AddTrainingDaysRequest();
        request.setTrainingDay("28/02/2022");
        request.setDescription("Test description");
        return request;
    }
}
