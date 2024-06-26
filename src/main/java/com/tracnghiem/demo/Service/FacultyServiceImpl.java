package com.tracnghiem.demo.Service;

import com.tracnghiem.demo.Entity.Faculty;
import com.tracnghiem.demo.Repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyServiceImpl implements IFacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    public List<Faculty> findAll() {
        return facultyRepository.findAll();
    }

    @Override
    public Optional<Faculty> findById(Integer id) {
        return facultyRepository.findById(id);
    }

    @Override
    public Faculty save(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public void deleteById(Integer id) {
        facultyRepository.deleteById(id);
    }
}
