
package com.tracnghiem.demo.Controller;

import com.tracnghiem.demo.Entity.Faculty;
import com.tracnghiem.demo.Service.IFacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/faculties")
public class FacultyController {

    @Autowired
    private IFacultyService facultyService;

    @GetMapping
    public List<Faculty> getAllFaculties() {
        return facultyService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Faculty> getFacultyById(@PathVariable Long id) {
        Optional<Faculty> faculty = facultyService.findById(id);
        if (faculty.isPresent()) {
            return ResponseEntity.ok(faculty.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyService.save(faculty);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Faculty> updateFaculty(@PathVariable Long id, @RequestBody Faculty facultyDetails) {
        Optional<Faculty> faculty = facultyService.findById(id);
        if (faculty.isPresent()) {
            Faculty updatedFaculty = faculty.get();
            //updatedFaculty.setName(facultyDetails.getName());
            return ResponseEntity.ok(facultyService.save(updatedFaculty));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFaculty(@PathVariable Long id) {
        if (facultyService.findById(id).isPresent()) {
            facultyService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

