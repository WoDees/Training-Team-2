package com.trainingApplication.repository.user;

import java.util.List;

public interface DefaultRepository<T> {

    T save(T entity);

    List<T> findAll();

    boolean remove(T entity);

    T getEntityById(Long id);

    boolean existsEntity(T entity);

}
