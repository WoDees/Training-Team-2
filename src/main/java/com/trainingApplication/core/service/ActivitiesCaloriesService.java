package com.trainingApplication.core.service;

import com.trainingApplication.repository.user.Repository;

public class ActivitiesCaloriesService {

    private final Repository repository;

    public ActivitiesCaloriesService(Repository repository) {
        this.repository = repository;
    }
}
