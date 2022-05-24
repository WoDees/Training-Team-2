package com.trainingApplication.repository.quiz;

import com.trainingApplication.domain.QuizEntity;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class HibernateQuizRepository implements QuizRepository {

    private final SessionFactory sessionFactory;

    public HibernateQuizRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public QuizEntity save(QuizEntity quizEntity) {
        sessionFactory.openSession().save(quizEntity);
        return quizEntity;
    }
}
