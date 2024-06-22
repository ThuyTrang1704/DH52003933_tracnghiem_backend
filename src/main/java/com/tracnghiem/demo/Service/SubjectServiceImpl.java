package com.tracnghiem.demo.Service;

import com.tracnghiem.demo.Entity.Subject;
import com.tracnghiem.demo.Repository.SubjectRepository;
import com.tracnghiem.demo.Service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements ISubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Optional<Subject> findById(Integer id) {
        return subjectRepository.findById(id);
    }

    @Override
    public Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public void deleteById(Integer id) {
        subjectRepository.deleteById(id);
    }
}
