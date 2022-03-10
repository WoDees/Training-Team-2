package dto.response;

import core.validation.CoreError;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class AddCalendarResponse {

    private Long createdCalendarId;
    private List<CoreError> errors;
}