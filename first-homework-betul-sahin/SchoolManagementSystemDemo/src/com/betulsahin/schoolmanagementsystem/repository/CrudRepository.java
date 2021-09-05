package com.betulsahin.schoolmanagementsystem.repository;

import java.util.List;

public interface CrudRepository<T> {
    List<T> findAll();
    T findById(Long id);
    void save(T object);
    void update(T object, Long id);
    void deleteById(Long id);
}
