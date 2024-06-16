package com.tracnghiem.demo.Controller;

import com.tracnghiem.demo.Entity.Faculty;
import com.tracnghiem.demo.Service.FacultyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/faculties")
public class FacultyController {

    @Autowired
    private FacultyServiceImpl facultyServiceImpl;

    @GetMapping
    public List<Faculty> getAllFaculties() {
        return facultyServiceImpl.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Faculty> getFacultyById(@PathVariable Integer id) {
        Optional<Faculty> faculty = facultyServiceImpl.findById(id);
        if (faculty.isPresent()) {
            return ResponseEntity.ok(faculty.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyServiceImpl.save(faculty);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Faculty> updateFaculty(@PathVariable Integer id, @RequestBody Faculty facultyDetails) {
        Optional<Faculty> faculty = facultyServiceImpl.findById(id);
        if (faculty.isPresent()) {
            Faculty updatedFaculty = faculty.get();
            updatedFaculty.setFacultyName(facultyDetails.getFacultyName());
            return ResponseEntity.ok(facultyServiceImpl.save(updatedFaculty));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFaculty(@PathVariable Integer id) {
        if (facultyServiceImpl.findById(id).isPresent()) {
            facultyServiceImpl.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
