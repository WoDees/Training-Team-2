package com.trainingApplication.repository.user;

import com.trainingApplication.domain.UserEntity;
import lombok.AllArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@AllArgsConstructor
@Repository
public class HibernateUserRepository implements DefaultRepository<UserEntity> {

    private SessionFactory sessionFactory;

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
    public boolean remove(UserEntity entity) {
        var copy = getEntityById(entity.getUserId());
        if (sessionFactory.getCurrentSession().contains(entity.getNickname(), entity)) {
            sessionFactory.getCurrentSession().remove(entity);
            return true;
        }
        return false;
    }

    public UserEntity getUserEntityByNickNameAndPassword(String nickname, String password) {
        String hql = "SELECT u FROM UserEntity u WHERE nickname =:nickname AND password =:password";
        var query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("nickname", nickname);
        query.setParameter("password", password);
        List<UserEntity> userEntities = (List<UserEntity>) query.list();
        return userEntities.stream().findFirst().orElse(null);
    }

    public boolean logOut(Long userId) {
        var copy = getEntityById(userId);
        copy.setOnlineStatus(false);
        sessionFactory.getCurrentSession().update(copy);
        return true;
    }

    public boolean logIn(Long userId) {
        var copy = getEntityById(userId);
        copy.setOnlineStatus(true);
        sessionFactory.getCurrentSession().update(copy);
        return true;
    }

    @Override
    public UserEntity getEntityById(Long userId) {
        return sessionFactory.getCurrentSession().get(UserEntity.class, userId);
    }

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

    public boolean existsUserByNickname(String nickname) {
        var query = sessionFactory.getCurrentSession().createQuery(
                "select u FROM UserEntity u where nickname = :nickname");
        query.setParameter("nickname", nickname);
        List<UserEntity> userList = (List<UserEntity>) query.getResultList();
        return !userList.isEmpty();
    }

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

    public boolean existsUserByMail(String mail) {
        var query = sessionFactory.getCurrentSession().createQuery(
                "select u FROM UserEntity u where mail = :mail");
        query.setParameter("mail", mail);
        List<UserEntity> userList = (List<UserEntity>) query.getResultList();
        return !userList.isEmpty();
    }

    public boolean verifyUserByNickname(String nickname) {
        var query = sessionFactory.getCurrentSession().createQuery(
                "select u FROM UserEntity u where nickname = :nickname");
        query.setParameter("nickname", nickname);
        List<UserEntity> userList = (List<UserEntity>) query.getResultList();
        return !userList.isEmpty();
    }

    public boolean verifyUserByPassword(String password) {
        var query = sessionFactory.getCurrentSession().createQuery(
                "select u FROM UserEntity u where password = :password");
        query.setParameter("password", password);
        List<UserEntity> userList = (List<UserEntity>) query.getResultList();
        return !userList.isEmpty();
    }

    @Override
    public boolean existsEntity(UserEntity entity) {
        return false;
    }

}
