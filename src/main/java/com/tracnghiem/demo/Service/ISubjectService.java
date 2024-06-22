package com.tracnghiem.demo.Service;
import com.tracnghiem.demo.Entity.Subject;

import java.util.List;
import java.util.Optional;

public interface ISubjectService {
    List<Subject> findAll();

    Optional<Subject> findById(Integer id);

    Subject save(Subject subject);

    void deleteById(Integer id);
}
