package com.trainingApplication.repository.user;

import com.trainingApplication.domain.UserEntity;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Restrictions;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import javax.management.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
        return sessionFactory.getCurrentSession().createQuery("SELECT * FROM Users", UserEntity.class).list();
    }

    @Override
    public boolean remove(String nickname, String password) {
        var copy = new UserEntity();
        copy.setNickname(nickname);
        copy.setPassword(password);
        if (sessionFactory.getCurrentSession().contains(nickname, copy)) {
            sessionFactory.getCurrentSession().remove(copy);
            return true;
        }
        return false;
    }

    @Override
    public UserEntity getUserEntityByNickNameAndPassword(String nickname, String password) {
        String hql = "SELECT * FROM Users WHERE nickname =:nickname AND password =:password";
        var query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("nickname", nickname);
        query.setParameter("password", password);
        List<UserEntity> userEntities = query.list();
        return userEntities.get(0);
    }

    @Override
    public boolean logOut(Long userId) {
        return false;
    }

    @Override
    public boolean logIn(Long userId) {
        return false;
    }

    @Override
    public UserEntity getUserById(Long userId) {
        return null;
    }

    @Override
    public UserEntity getUserByNickName(String nickname) {
        UserEntity user = (UserEntity) sessionFactory.getCurrentSession().createCriteria(UserEntity.class)
                .add(Restrictions.eq("nickname", nickname))
                .uniqueResult();
        return user;
    }

    @Override
    public UserEntity getUserByMail(String mail) {


        var query = sessionFactory.getCurrentSession().createQuery(
                "select u FROM UserEntity u where mail = :mail");
        query.setParameter("mail",mail);
        List<UserEntity> userList  = (List<UserEntity>) query.getResultList();
        if (!userList.isEmpty()){
            return userList.get(0);
        }
        return null;
    }

    @Override
    public boolean existsUserByMail(String mail){
        var query = sessionFactory.getCurrentSession().createQuery(
                "select u FROM UserEntity u where mail = :mail");
        query.setParameter("mail",mail);
        List<UserEntity> userList  = (List<UserEntity>) query.getResultList();
        return !userList.isEmpty();
    }

    @Override
    public boolean verifyUserByNickname(String nickname) {
        var copy = new UserEntity();
        copy.setNickname(nickname);
        return sessionFactory.getCurrentSession().contains(nickname, copy);
    }

    @Override
    public boolean verifyUserByPassword(String password) {
        var copy = new UserEntity();
        copy.setNickname(password);
        return sessionFactory.getCurrentSession().contains(password, copy);
    }

}
