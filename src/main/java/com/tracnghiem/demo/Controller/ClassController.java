package com.tracnghiem.demo.Controller;

import com.tracnghiem.demo.Entity.ClassEntity;
import com.tracnghiem.demo.Service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/classes")
public class ClassController {

    @Autowired
    private IClassService classService;

    @GetMapping
    public List<ClassEntity> getAllClasses() {
        return classService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassEntity> getClassById(@PathVariable Integer id) {
        Optional<ClassEntity> classEntity = classService.findById(id);
        if (classEntity.isPresent()) {
            return ResponseEntity.ok(classEntity.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ClassEntity createClass(@RequestBody ClassEntity classEntity) {
        return classService.save(classEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClassEntity> updateClass(@PathVariable Integer id,
                                                   @RequestBody ClassEntity classDetails) {
        Optional<ClassEntity> classEntity = classService.findById(id);
        if (classEntity.isPresent()) {
            ClassEntity updatedClass = classEntity.get();
//            updatedClass.setNameClass(classDetails.getNameClass());
//            updatedClass.setFaculty(classDetails.getFaculty());
            return ResponseEntity.ok(classService.save(updatedClass));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClass(@PathVariable Integer id) {
        if (classService.findById(id).isPresent()) {
            classService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
