package com.trainingApplication.core.service;

import com.trainingApplication.domain.TrainingDaysEntity;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@AllArgsConstructor
public class SearchTrainingDayByTrainingDateSpecification implements Specification<TrainingDaysEntity> {

    private final String trainingDate;

    @Override
    public Predicate toPredicate(Root<TrainingDaysEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.equal(root.get("trainingDate"), trainingDate);
    }
}
