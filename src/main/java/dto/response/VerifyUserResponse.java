package dto.response;

import core.validation.CoreError;
import lombok.Data;

import java.util.List;

@Data
public class VerifyUserResponse {

    private boolean onlineStatus;
    private List<CoreError> errors;
    private Long userId;

}
