package com.trainingApplication.repository;

import com.trainingApplication.domain.TrainingDaysEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;

import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Component
public class DefaultTrainingDaysRepository implements TrainingDaysRepository {

    private final JdbcTemplate jdbcTemplate;

    public DefaultTrainingDaysRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public TrainingDaysEntity save(TrainingDaysEntity trainingDaysEntity) {
        var query = "INSERT INTO TrainingDays(trainingDate, description) VALUES (?, ?)";
        var keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            var ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, trainingDaysEntity.getTrainingDate());
            ps.setString(2, trainingDaysEntity.getDescription());
            return ps;
        }, keyHolder);
        trainingDaysEntity.setUserId(keyHolder.getKey().longValue());
        return trainingDaysEntity;
    }

    @Override
    public List<TrainingDaysEntity> findAllTrainingDays() {
        return jdbcTemplate.query("SELECT * FROM TrainingDays", new BeanPropertyRowMapper(TrainingDaysEntity.class));
    }

    @Override
    public Optional<TrainingDaysEntity> findTrainingDaysById(Long id) {
        var result = (TrainingDaysEntity) jdbcTemplate.queryForObject("SELECT * FROM TrainingDays WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper(TrainingDaysEntity.class));
        return Optional.ofNullable(result);
    }

    @Override
    public void addDayToUser(TrainingDaysEntity trainingDaysEntity) {

    }
}
