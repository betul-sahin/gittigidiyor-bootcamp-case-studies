package com.betulsahin.schoolmanagementsystemdemov3.service;

import java.util.List;

public interface BaseService<T> {
    List<T> findAll();
    T findById(Long id);
    T save(T object);
    T update(T object);
    void deleteById(Long id);
}
