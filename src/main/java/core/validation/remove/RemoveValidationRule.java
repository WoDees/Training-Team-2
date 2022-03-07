package core.validation.remove;

import dto.request.RemoveUserRequest;

public interface RemoveValidationRule {

    void validate(RemoveUserRequest request);
}
