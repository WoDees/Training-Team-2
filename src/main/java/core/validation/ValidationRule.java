package core.validation;

import domain.UserEntity;
import dto.request.AddUserRequest;

public interface ValidationRule {

    void validate(AddUserRequest request);

    default void checkNotNull(UserEntity entity) {
        if (entity == null) {
            throw new ValidationException("User must not be null.");
        }
    }
}
