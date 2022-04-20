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
@Table(name = "Quiz")
public class QuizEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "gender", nullable = false)
    private Long gender;
    @Column(name = "age", nullable = false)
    private Long age;
    @Column(name = "weight", nullable = false)
    private Long weight;
    @Column(name = "growth", nullable = false)
    private Long growth;
    @Column(name = "desiredWeight", nullable = false)
    private Long desiredWeight;
    @Column(name = "target", nullable = false)
    private String target;

    @Column(name = "userId", nullable = false)
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private Long userId;
}
