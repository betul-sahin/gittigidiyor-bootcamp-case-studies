package com.betulsahin.springbootcamp.schoolmanagementsystemdemov2.repository;

import java.util.List;

public interface CrudRepository<T> {
    List<T> findAll();
    T findById(Long id);
    T save(T object);
    T update(T object);
    void deleteById(Long id);
}
