package com.codegym.repository;

import com.codegym.model.Students;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentsRepository extends PagingAndSortingRepository<Students, Long> {
}
