package dto.request;

import lombok.Data;

@Data
public class VerifyUserRequest {

    private String nickname;
    private String password;

}
