package test_factory;

import com.trainingApplication.domain.TrainingDaysEntity;
import com.trainingApplication.dto.request.AddTrainingDaysRequest;

import java.util.List;

public class TestTrainingDaysDtoFactory {

    public static AddTrainingDaysRequest createAddCalendarRequest() {
        var request = new AddTrainingDaysRequest();
        request.setTrainingDate("14/03/2022");
        request.setDescription("Test_Description");
        return request;
    }

    public static AddTrainingDaysRequest createRequestWithoutDescription() {
        var request = new AddTrainingDaysRequest();
        request.setTrainingDate("14/03/2022");
        return request;
    }

    public static AddTrainingDaysRequest createRequestWithoutEventDate() {
        var request = new AddTrainingDaysRequest();
        request.setDescription("Test_Description");
        return request;
    }

    public static TrainingDaysEntity createEntity(Long id) {
        var entity = new TrainingDaysEntity();
        entity.setId(id);
        entity.setUserId(id);
        entity.setEventDate("28/02/2022");
        entity.setDescription("Test description");
        return entity;
    }

    public static AddTrainingDaysRequest createRequest() {
        var request = new AddTrainingDaysRequest();
        request.setTrainingDate("28/02/2022");
        request.setDescription("Test description");
        return request;
    }

    public static List<TrainingDaysEntity> createEntities() {
        var returnEntity = new TrainingDaysEntity();
        returnEntity.setId(1L);
        returnEntity.setUserId(1L);
        returnEntity.setDescription("Test description");
        returnEntity.setEventDate("28/02/2022");
        return List.of(returnEntity);
    }
}
