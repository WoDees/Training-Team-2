package com.trainingApplication.repository.quiz;

import com.trainingApplication.domain.QuizEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<QuizEntity, Long> {

    List<QuizEntity> findAll();
}
