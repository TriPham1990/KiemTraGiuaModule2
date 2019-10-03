package com.codegym.service;

import com.codegym.model.Classes;
import com.codegym.model.Students;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface StudentsService {
    Iterable<Students> findAllByClasses(Classes classes);

    Page<Students> findAll(Pageable pageable);

    Students findById(Long id);

    void save(Students student);

    void remove(Long id);
}
