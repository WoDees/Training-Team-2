package com.trainingApplication.repository;

import com.trainingApplication.domain.TrainingDaysEntity;
import com.trainingApplication.domain.UserEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.List;

@Component
public class DefaultUserRepository implements Repository {

    private final JdbcTemplate jdbcTemplate;

    public DefaultUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public UserEntity save(UserEntity userEntity) {
        var query = "INSERT INTO Users(nickname, mail, password, onlineStatus) VALUES (?, ?, ?, ?)";
        var keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            var ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, userEntity.getNickname());
            ps.setString(2, userEntity.getMail());
            ps.setString(3, userEntity.getPassword());
            ps.setBoolean(4, userEntity.isOnlineStatus());
            return ps;
        }, keyHolder);
        userEntity.setUserId(keyHolder.getKey().longValue());
        return userEntity;
    }

    @Override
    public List<UserEntity> findAll() {
        return jdbcTemplate.query("SELECT * FROM Users", new BeanPropertyRowMapper(UserEntity.class));
    }

    @Override
    public boolean remove(String nickname, String password) {
        return false;
    }

    @Override
    public UserEntity getUserEntityByNickNameAndPassword(String nickname, String password) {
        return jdbcTemplate.query("SELECT * FROM Users WHERE nickname = ? AND password = ?", new Object[]{nickname, password}, new BeanPropertyRowMapper<>(UserEntity.class)).
                stream().findAny().orElse(null);

    }

    @Override
    public boolean logOut(Long userId) {
        return false;
    }

    @Override
    public UserEntity getUserById(Long userId) {
        return null;
    }

    @Override
    public UserEntity getUserByNickName(String nickname) {
        return jdbcTemplate.query("SELECT * FROM Users WHERE nickname = ?", new Object[]{nickname}, new BeanPropertyRowMapper<>(UserEntity.class)).
                stream().findAny().orElse(null);
    }

    @Override
    public UserEntity getUserByMail(String mail) {
        return null;
    }

    @Override
    public boolean verifyUserByNickname(String nickname) {
        Integer count = jdbcTemplate.queryForObject("SELECT count(*) FROM Users WHERE nickname = ? ", new Object[]{nickname}, Integer.class);
        return count != null && count > 0;
    }

    @Override
    public boolean verifyUserByPassword(String password) {
        Integer count = jdbcTemplate.queryForObject("SELECT count(*) FROM Users WHERE password = ? ", new Object[]{password}, Integer.class);
        return count != null && count > 0;
    }

    @Override
    public void addTrainingDaysToUser(Long userId, TrainingDaysEntity entity) {

    }
}
