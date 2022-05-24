package com.trainingApplication.repository.user;

import com.trainingApplication.domain.TrainingDaysEntity;
import com.trainingApplication.domain.UserEntity;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class HibernateUserRepository implements UserRepository {

    private final SessionFactory sessionFactory;

    public HibernateUserRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

    }

    @Override
    public UserEntity save(UserEntity userEntity) {
        sessionFactory.openSession().save(userEntity);
        return userEntity;
    }

    @Override
    public List<UserEntity> findAll() {
        return sessionFactory.openSession().createQuery("SELECT u FROM UserEntity u", UserEntity.class).list();
    }

    @Override
    public boolean remove(Long id) {
        var entity = getUserById(id);

        if (sessionFactory.openSession().contains("entity", entity.orElse(null))) {
            sessionFactory.openSession().remove(entity);
            return true;
        }
        return false;
    }

    @Override
    public UserEntity getUserEntityByNickNameAndPassword(String nickname, String password) {
        String hql = "SELECT u FROM UserEntity u WHERE nickname =:nickname AND password =:password";
        var query = sessionFactory.openSession().createQuery(hql);
        query.setParameter("nickname", nickname);
        query.setParameter("password", password);
        List<UserEntity> userEntities = (List<UserEntity>) query.list();
        return userEntities.stream().findFirst().orElse(null);
    }

    @Override
    public Optional<UserEntity> getUserById(Long userId) {
        var entity = (sessionFactory.openSession().get(UserEntity.class, userId));
        return Optional.ofNullable(entity);
    }

    @Override
    public UserEntity getUserByNickName(String nickname) {
        var query = sessionFactory.openSession().createQuery(
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
        var query = sessionFactory.openSession().createQuery(
                "select u FROM UserEntity u where nickname = :nickname");
        query.setParameter("nickname", nickname);
        List<UserEntity> userList = (List<UserEntity>) query.getResultList();
        return !userList.isEmpty();
    }

    @Override
    public UserEntity getUserByMail(String mail) {
        var query = sessionFactory.openSession().createQuery(
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
        var query = sessionFactory.openSession().createQuery(
                "select u FROM UserEntity u where mail = :mail");
        query.setParameter("mail", mail);
        List<UserEntity> userList = (List<UserEntity>) query.getResultList();
        return !userList.isEmpty();
    }

    @Override
    public boolean verifyUserByNickname(String nickname) {
        var query = sessionFactory.openSession().createQuery(
                "select u FROM UserEntity u where nickname = :nickname");
        query.setParameter("nickname", nickname);
        List<UserEntity> userList = (List<UserEntity>) query.getResultList();
        return !userList.isEmpty();
    }

    @Override
    public boolean verifyUserByPassword(String password) {
        var query = sessionFactory.openSession().createQuery(
                "select u FROM UserEntity u where password = :password");
        query.setParameter("password", password);
        List<UserEntity> userList = (List<UserEntity>) query.getResultList();
        return !userList.isEmpty();
    }
}
