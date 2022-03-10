package dto.response;

import dto.UserEntityDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FindAllUserResponse {

    private List<UserEntityDTO> userEntityDTOList;

}
