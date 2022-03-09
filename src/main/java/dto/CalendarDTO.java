package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalendarDTO {

    private Long id;
    private Long userId;
    private String description;
    private String eventDate;

}
