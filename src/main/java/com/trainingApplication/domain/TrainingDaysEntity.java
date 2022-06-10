package com.trainingApplication.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "training_days")
public class TrainingDaysEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "description")
    private String description;
    @Column(name = "training_day")
    private String trainingDay;

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @Column(name = "user_id")
    private Long userId;
}
