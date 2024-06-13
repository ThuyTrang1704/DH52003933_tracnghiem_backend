package com.tracnghiem.demo.Service;

import com.tracnghiem.demo.Entity.ClassEntity;

import java.util.List;
import java.util.Optional;

public interface IClassService {
    List<ClassEntity> findAll();
    Optional<ClassEntity> findById(Integer id);
    ClassEntity save(ClassEntity classEntity);
    void deleteById(Integer id);
}
