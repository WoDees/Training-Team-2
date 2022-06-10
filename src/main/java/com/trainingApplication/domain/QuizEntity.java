package com.trainingApplication.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "quiz")
public class QuizEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "gender")
    private Long gender;
    @Column(name = "age")
    private Long age;
    @Column(name = "weight")
    private Long weight;
    @Column(name = "growth")
    private Long growth;
    @Column(name = "desired_weight")
    private Long desiredWeight;
    @Column(name = "target")
    private String target;

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @Column(name = "user_id")
    private Long userId;
}
