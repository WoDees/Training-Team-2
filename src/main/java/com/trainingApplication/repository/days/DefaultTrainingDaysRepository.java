package com.trainingApplication.repository.days;

import com.trainingApplication.domain.TrainingDaysEntity;
import com.trainingApplication.domain.UserEntity;
import com.trainingApplication.repository.user.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public class DefaultTrainingDaysRepository implements TrainingDaysRepository {

    private final JdbcTemplate jdbcTemplate;

    public DefaultTrainingDaysRepository(JdbcTemplate jdbcTemplate, Repository repository) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public TrainingDaysEntity save(TrainingDaysEntity trainingDaysEntity) {
        var query = "INSERT INTO trainingDays(trainingDate, description, userId) VALUES (?, ?, ?)";
        var keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            var ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, trainingDaysEntity.getTrainingDate());
            ps.setString(2, trainingDaysEntity.getDescription());
            ps.setLong(3, trainingDaysEntity.getUserId());
            return ps;
        }, keyHolder);
        trainingDaysEntity.setId(keyHolder.getKey().longValue());
        addDayToUser(trainingDaysEntity);
        return trainingDaysEntity;
    }

    @Override
    public List<TrainingDaysEntity> findAllTrainingDays() {
        return jdbcTemplate.query("SELECT * FROM trainingDays", new BeanPropertyRowMapper(TrainingDaysEntity.class));
    }

    @Override
    public Optional<TrainingDaysEntity> findTrainingDaysById(Long id) {
        var result = (TrainingDaysEntity) jdbcTemplate.queryForObject("SELECT * FROM trainingDays WHERE id= ?", new Object[]{id}, new BeanPropertyRowMapper(TrainingDaysEntity.class));
        return Optional.ofNullable(result);
    }

    @Override
    public UserEntity getUserById(Long userId) {
        return null;
    }

    @Override
    public Long addTrainingDaysToUser(Long userId) {
        return null;
    }

    public void addDayToUser(TrainingDaysEntity trainingDaysEntity) {
        var currentCount = getUserDaysCount(trainingDaysEntity.getUserId());
        if (currentCount == null) {
            currentCount = 0L;
        }
        var userId = trainingDaysEntity.getUserId();
        long count = 1L + currentCount;
        jdbcTemplate.update("UPDATE Users SET trainingDaysCount = ? WHERE userId = ?", count, userId);
    }

    public Long getUserDaysCount(Long userId) {
        var entity = jdbcTemplate.query("SELECT * FROM Users WHERE userId = ?", new Object[]{userId}, new BeanPropertyRowMapper<>(UserEntity.class)).
                stream().findAny().orElse(null);
        assert entity != null;
        return entity.getTrainingDaysCount();
    }
}
