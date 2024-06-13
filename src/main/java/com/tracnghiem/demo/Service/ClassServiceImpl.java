package com.tracnghiem.demo.Service.impl;

import com.tracnghiem.demo.Entity.ClassEntity;
import com.tracnghiem.demo.Repository.ClassRepository;
import com.tracnghiem.demo.Service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassServiceImpl implements IClassService {

    @Autowired
    private ClassRepository classRepository;

    @Override
    public List<ClassEntity> findAll() {
        return classRepository.findAll();
    }

    @Override
    public Optional<ClassEntity> findById(Integer id) {
        return classRepository.findById(id);
    }

    @Override
    public ClassEntity save(ClassEntity classEntity) {
        return classRepository.save(classEntity);
    }

    @Override
    public void deleteById(Integer id) {
        classRepository.deleteById(id);
    }
}
