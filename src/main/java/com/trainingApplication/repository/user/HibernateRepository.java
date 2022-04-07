package com.trainingApplication.repository.user;

import com.trainingApplication.domain.UserEntity;
import org.hibernate.SessionFactory;

import java.util.List;

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
        return null;
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
        return null;
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
        return null;
    }

    @Override
    public UserEntity getUserByMail(String mail) {
        return null;
    }

    @Override
    public boolean verifyUserByNickname(String nickname) {
        return false;
    }

    @Override
    public boolean verifyUserByPassword(String password) {
        return false;
    }

}
