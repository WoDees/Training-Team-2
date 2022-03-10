package dto.request;

import lombok.Data;

@Data
public class AddUserRequest {

    private String nickname;
    private String mail;
    private String password;

}