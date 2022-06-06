package test_factory;

import com.trainingApplication.domain.TrainingDaysEntity;
import com.trainingApplication.dto.request.AddTrainingDaysRequest;

public class TestTrainingDaysDtoFactory {

    public static AddTrainingDaysRequest createAddCalendarRequest() {
        var request = new AddTrainingDaysRequest();
        request.setTrainingDate("14/03/2022");
        request.setDescription("Test_Description");
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
        entity.setTrainingDate("28/02/2022");
        entity.setDescription("Test description");
        return entity;
    }

    public static AddTrainingDaysRequest createRequest() {
        var request = new AddTrainingDaysRequest();
        request.setTrainingDate("28/02/2022");
        request.setDescription("Test description");
        return request;
    }
}
