package dto.request;

import lombok.Data;

@Data
public class RemoveUserRequest {

    private String nickname;
    private String password;

}
