package com.tracnghiem.demo.Service;

import com.tracnghiem.demo.DTO.Role.RoleCreateForm;
import com.tracnghiem.demo.DTO.Role.RoleUpdateForm;
import com.tracnghiem.demo.Entity.Role;
import com.tracnghiem.demo.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements IRoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Page<Role> getAllRoles(Pageable pageable) {
        return roleRepository.findAll(pageable);
    }

    @Override
    public Optional<Role> getRoleById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public void createRole(RoleCreateForm form) {
        
    }

    @Override
    public void updateRole(RoleUpdateForm form) {

    }

    @Override
    public Role updateRole(Long id, RoleUpdateForm form) {
        return null;
    }

    @Override
    public void deleteRole(Long id) {

    }

    //   @Override
//    public Role createRole(RoleCreateForm form) {
//        Role role = new Role();
//        role.setName(form.getName());
//        // Set other fields as necessary
//        return roleRepository.save(role);
//    }
//
//    @Override
//    public void updateRole(RoleUpdateForm form) {
//
//    }
//
//    @Override
//    public Role updateRole(Long id, RoleUpdateForm form) {
//        Optional<Role> existingRole = roleRepository.findById(id);
//        if (existingRole.isPresent()) {
//            Role role = existingRole.get();
//            role.setName(form.getName());
//            // Update other fields as necessary
//            return roleRepository.save(role);
//        } else {
//            throw new RuntimeException("Role not found with id " + id);
//        }
//    }

//    @Override
//    public void deleteRole(Long id) {
//        if (roleRepository.existsById(id)) {
//            roleRepository.deleteById(id);
//        } else {
//            throw new RuntimeException("Role not found with id " + id);
//        }
//    }
}
