package com.trainingApplication.repository;

import com.trainingApplication.domain.TrainingDaysEntity;
import com.trainingApplication.domain.UserEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultUserRepository implements Repository{

    private final JdbcTemplate jdbcTemplate;

    public DefaultUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public UserEntity save(UserEntity userEntity) {
        return null;
    }

    @Override
    public List<UserEntity> findAll() {
        return jdbcTemplate.query("SELECT * FROM User", new BeanPropertyRowMapper(UserEntity.class));
    }

    @Override
    public boolean verify(String nickname, String password) {
        return false;
    }

    @Override
    public boolean remove(String nickname, String password) {
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
    public void logIn(Long userId) {

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

    @Override
    public void addTrainingDaysToUser(Long userId, TrainingDaysEntity entity) {

    }
}
