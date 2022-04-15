package com.trainingApplication.repository.days;

import com.trainingApplication.domain.TrainingDaysEntity;
import com.trainingApplication.domain.UserEntity;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class HibernateTrainingDaysRepository implements TrainingDaysRepository {

    private final SessionFactory sessionFactory;

    public HibernateTrainingDaysRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public TrainingDaysEntity save(TrainingDaysEntity trainingDaysEntity) {
        sessionFactory.getCurrentSession().save(trainingDaysEntity);
        addTrainingDaysToUser(trainingDaysEntity.getUserId());
        return trainingDaysEntity;
    }

    @Override
    public UserEntity getUserById(Long userId) {
        return sessionFactory.getCurrentSession().get(UserEntity.class, userId);
    }

    @Override
    public List<TrainingDaysEntity> findAllTrainingDays() {
        return sessionFactory.getCurrentSession().createQuery(
                "SELECT t FROM TrainingDaysEntity t", TrainingDaysEntity.class).list();
    }

    @Override
    public Optional<TrainingDaysEntity> findTrainingDaysById(Long id) {
        var entity = (sessionFactory.getCurrentSession().get(TrainingDaysEntity.class, id));
        return Optional.ofNullable(entity);
    }

    @Override
    public Long addTrainingDaysToUser(Long userId) {
        var copy = getUserById(userId);
        copy.setTrainingDaysCount(copy.getTrainingDaysCount() + 1L);
        sessionFactory.getCurrentSession().update(copy);
        return copy.getTrainingDaysCount() + 1L;
    }
}
