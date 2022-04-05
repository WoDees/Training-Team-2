package com.trainingApplication.domain;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Long userId;
    @Column(name = "nickname", unique = true, nullable = false, length = 12)
    private String nickname;
    @Column(name = "password", unique = true, nullable = false, length = 14)
    private String password;
    @Column(name = "mail", unique = true, nullable = false)
    private String mail;
    @Column(name = "onlineStatus")
    private boolean onlineStatus;
    private List<TrainingDaysEntity> trainingDaysEntitiesList;
}
