package dto.response;

import dto.CalendarDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FindAllCalendarResponse {

    private List<CalendarDTO> calendars;
}