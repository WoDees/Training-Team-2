package core.validation.authorization.registration;

import dto.request.AddUserRequest;

public interface RegistrationValidationRule {

    void validate(AddUserRequest request);

}
