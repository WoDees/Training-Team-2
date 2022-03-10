package domain;

import lombok.Data;

@Data
public class UserEntity {

    private Long userId;
    private String nickname;
    private String password;
    private String mail;
    private boolean onlineStatus;

}
