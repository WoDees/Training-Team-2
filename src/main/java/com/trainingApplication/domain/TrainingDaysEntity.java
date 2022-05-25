package com.trainingApplication.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "trainingDays")
public class TrainingDaysEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "description", nullable = false, length = 50)
    private String description;
    @Column(name = "trainingDate", nullable = false)
    private String trainingDate;

    @Column(name = "user_id")
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Long userId;
}
