package com.trainingApplication.repository.user;

import com.trainingApplication.domain.TrainingDaysEntity;
import com.trainingApplication.domain.UserEntity;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class HibernateRepository implements Repository {

    private final SessionFactory sessionFactory;

    public HibernateRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

    }

    @Override
    public UserEntity save(UserEntity userEntity) {
        sessionFactory.getCurrentSession().save(userEntity);
        return userEntity;
    }

    @Override
    public List<UserEntity> findAll() {
        return sessionFactory.getCurrentSession().createQuery("SELECT u FROM UserEntity u", UserEntity.class).list();
    }

    @Override
    public boolean remove(String nickname, String password) {
        var entity = getUserEntityByNickNameAndPassword(nickname, password);
        if (sessionFactory.getCurrentSession().contains(entity.getNickname(), entity)) {
            sessionFactory.getCurrentSession().remove(entity);
            return true;
        }
        return false;
    }

    @Override
    public UserEntity getUserEntityByNickNameAndPassword(String nickname, String password) {
        String hql = "SELECT u FROM UserEntity u WHERE nickname =:nickname AND password =:password";
        var query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("nickname", nickname);
        query.setParameter("password", password);
        List<UserEntity> userEntities = (List<UserEntity>) query.list();
        return userEntities.stream().findFirst().orElse(null);
    }

    @Override
    public boolean logOut(Long userId) {
        var copy = getUserById(userId);
        copy.setOnlineStatus(false);
        sessionFactory.getCurrentSession().update(copy);
        return true;
    }

    @Override
    public boolean logIn(Long userId) {
        var copy = getUserById(userId);
        copy.setOnlineStatus(true);
        sessionFactory.getCurrentSession().update(copy);
        return true;
    }

    @Override
    public UserEntity getUserById(Long userId) {
        return sessionFactory.getCurrentSession().get(UserEntity.class, userId);
    }

    @Override
    public UserEntity getUserByNickName(String nickname) {
        var query = sessionFactory.getCurrentSession().createQuery(
                "select u FROM UserEntity u where mail = :nickname");
        query.setParameter("nickname", nickname);
        List<UserEntity> userList = (List<UserEntity>) query.getResultList();
        if (!userList.isEmpty()) {
            return userList.get(0);
        }
        return null;
    }

    @Override
    public boolean existsUserByNickname(String nickname) {
        var query = sessionFactory.getCurrentSession().createQuery(
                "select u FROM UserEntity u where nickname = :nickname");
        query.setParameter("nickname", nickname);
        List<UserEntity> userList = (List<UserEntity>) query.getResultList();
        return !userList.isEmpty();
    }

    @Override
    public UserEntity getUserByMail(String mail) {
        var query = sessionFactory.getCurrentSession().createQuery(
                "select u FROM UserEntity u where mail = :mail");
        query.setParameter("mail", mail);
        List<UserEntity> userList = (List<UserEntity>) query.getResultList();
        if (!userList.isEmpty()) {
            return userList.get(0);
        }
        return null;
    }

    @Override
    public boolean existsUserByMail(String mail) {
        var query = sessionFactory.getCurrentSession().createQuery(
                "select u FROM UserEntity u where mail = :mail");
        query.setParameter("mail", mail);
        List<UserEntity> userList = (List<UserEntity>) query.getResultList();
        return !userList.isEmpty();
    }

    @Override
    public boolean verifyUserByNickname(String nickname) {
        var query = sessionFactory.getCurrentSession().createQuery(
                "select u FROM UserEntity u where nickname = :nickname");
        query.setParameter("nickname", nickname);
        List<UserEntity> userList = (List<UserEntity>) query.getResultList();
        return !userList.isEmpty();
    }

    @Override
    public boolean verifyUserByPassword(String password) {
        var query = sessionFactory.getCurrentSession().createQuery(
                "select u FROM UserEntity u where password = :password");
        query.setParameter("password", password);
        List<UserEntity> userList = (List<UserEntity>) query.getResultList();
        return !userList.isEmpty();
    }

    @Override
    public void addTrainingDaysToUser(TrainingDaysEntity trainingDaysEntity) {
        var currentCount = getUserDaysCount(trainingDaysEntity.getUserId());
        if (currentCount == null) {
            currentCount = 0L;
        }
        var userId = getUserById(trainingDaysEntity.getUserId());
        long count = 1L + currentCount;
        var query = sessionFactory.getCurrentSession().createQuery(
                "update UserEntity u SET trainingDaysCount  = :trainingDaysCount WHERE userId  = :userId");
        query.setParameter("trainingDaysCount", count);
        query.setParameter("userId", userId);
    }

    @Override
    public Long getUserDaysCount(Long userId) {
        var query = sessionFactory.getCurrentSession().createQuery(
                "select u FROM UserEntity u where userId = :userId");
        query.setParameter("userId", userId);
        List<UserEntity> userList = (List<UserEntity>) query.getResultList();
        if (!userList.isEmpty()) {
            return userList.get(0).getTrainingDaysCount();
        }
        return null;
    }
}
