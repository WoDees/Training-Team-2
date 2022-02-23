package core.validation;

import domain.UserEntity;

public interface ValidationRule {

    void validate(UserEntity entity);

    default void checkNotNull(UserEntity entity) {
        if (entity == null) {
            throw new ValidationException("User must not be null.");
        }
    }
}
