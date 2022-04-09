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
        return trainingDaysEntity;
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
    public Long getUserDaysCount(Long userId) {
        var query = sessionFactory.getCurrentSession().createQuery(
                "select u FROM UserEntity u WHERE userId = :userId");
        query.setParameter("userId", userId);
        List<UserEntity> copy = (List<UserEntity>) query.getResultList();
        if (!copy.isEmpty()){
            return copy.get(0).getTrainingDaysCount();
        }
        return null;
    }
}
