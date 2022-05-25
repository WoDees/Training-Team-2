package com.trainingApplication.repository.quiz;

import com.trainingApplication.domain.QuizEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<QuizEntity, Long> {
}
