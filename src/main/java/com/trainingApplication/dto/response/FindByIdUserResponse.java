package com.trainingApplication.dto.response;

import com.trainingApplication.dto.UserEntityDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindByIdUserResponse {

    private UserEntityDTO userEntityDTO;
}
