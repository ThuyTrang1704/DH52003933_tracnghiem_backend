package com.tracnghiem.demo.Controller;

import com.tracnghiem.demo.Entity.Subject;
import com.tracnghiem.demo.Service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

    @Autowired
    private ISubjectService subjectService;

    @GetMapping
    public List<Subject> getAllSubjects() {
        return subjectService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable Integer id) {
        Optional<Subject> subjectEntity = subjectService.findById(id);
        if (subjectEntity.isPresent()) {
            return ResponseEntity.ok(subjectEntity.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Subject createSubject(@RequestBody Subject subjectEntity) {
        return subjectService.save(subjectEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Subject> updateSubject(@PathVariable Integer id,
                                                       @RequestBody Subject subjectDetails) {
        Optional<Subject> subjectEntity = subjectService.findById(id);
        if (subjectEntity.isPresent()) {
            Subject updatedSubject = subjectEntity.get();
            updatedSubject.setSubjectName(subjectDetails.getSubjectName());
            return ResponseEntity.ok(subjectService.save(updatedSubject));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubject(@PathVariable Integer id) {
        if (subjectService.findById(id).isPresent()) {
            subjectService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
