package com.tracnghiem.demo.Controller;

import com.tracnghiem.demo.DTO.Role.RoleCreateForm;
import com.tracnghiem.demo.DTO.Role.RoleUpdateForm;
import com.tracnghiem.demo.Entity.Role;
import com.tracnghiem.demo.Service.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    @Autowired
    private RoleServiceImpl roleService;

    @GetMapping
    public Page<Role> getAllRoles(Pageable pageable) {
        return roleService.getAllRoles(pageable);
    }


    @PostMapping
    public void createRole(@RequestBody RoleCreateForm form) {
        roleService.createRole(form);
    }

    @PutMapping("/{id}")
    public void updateRole(@PathVariable(name = "id") int id,
                           @RequestBody RoleUpdateForm form) {
        form.setId(id);
        roleService.updateRole(form);
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
    }
}
