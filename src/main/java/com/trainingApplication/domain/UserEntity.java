package com.trainingApplication.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(name = "nickname", unique = true, nullable = false, length = 12)
    private String nickname;
    @Column(name = "password", nullable = false, length = 14)
    private String password;
    @Column(name = "mail", length = 45, unique = true, nullable = false)
    private String mail;
    @Column(name = "onlineStatus")
    private boolean onlineStatus;
    @Column(name = "trainingDaysCount")
    private Long trainingDaysCount;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private List<TrainingDaysEntity> trainingDaysEntities;
}
