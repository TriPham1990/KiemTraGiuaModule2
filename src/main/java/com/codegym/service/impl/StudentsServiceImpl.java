package com.codegym.service.impl;

import com.codegym.model.Classes;
import com.codegym.model.Students;
import com.codegym.repository.StudentsRepository;
import com.codegym.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class StudentsServiceImpl implements StudentsService {
    @Autowired
    private StudentsRepository studentsRepository;

    @Override
    public Iterable<Students> findAllByClasses(Classes classes) {
        return studentsRepository.findAllByClasses(classes);
    }

    @Override
    public Page<Students> findAll(Pageable pageable) {
        return studentsRepository.findAll(pageable);
    }

    @Override
    public Students findById(Long id) {
        return studentsRepository.findOne(id);
    }

    @Override
    public void save(Students student) {
        studentsRepository.save(student);
    }

    @Override
    public void remove(Long id) {
        studentsRepository.delete(id);
    }
}
