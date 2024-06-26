package com.tracnghiem.demo.Service;

import com.tracnghiem.demo.Entity.Faculty;

import java.util.List;
import java.util.Optional;

public interface IFacultyService {
    List<Faculty> findAll();
    Optional<Faculty> findById(Integer id);
    Faculty save(Faculty faculty);
    void deleteById(Integer id);
}
