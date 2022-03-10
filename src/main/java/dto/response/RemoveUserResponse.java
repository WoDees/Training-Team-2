package dto.response;

import core.validation.CoreError;
import lombok.Data;

import java.util.List;

@Data
public class RemoveUserResponse {

    private List<CoreError> errors;
    private boolean removedAccount;

}
