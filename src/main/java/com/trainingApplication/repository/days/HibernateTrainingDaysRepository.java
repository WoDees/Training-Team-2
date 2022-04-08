package com.trainingApplication.repository.days;

import com.trainingApplication.domain.TrainingDaysEntity;
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
        sessionFactory.getCurrentSession().createQuery("SELECT t FROM trainingDays t").getResultList();
        return null;
    }

    @Override
    public Optional<TrainingDaysEntity> findTrainingDaysById(Long id) {
        var entity = (sessionFactory.getCurrentSession().get(TrainingDaysEntity.class, id));
        return Optional.ofNullable(entity);
    }

    @Override
    public void addDayToUser(TrainingDaysEntity trainingDaysEntity) {

    }

    @Override
    public Long getUserDaysCount(Long userId) {
        return null;
    }
}
