package com.codegym.service;

import com.codegym.model.Students;


public interface StudentsService {
    Iterable<Students> findAll();

    Students findById(Long id);

    void save(Students student);

    void remove(Long id);
}
