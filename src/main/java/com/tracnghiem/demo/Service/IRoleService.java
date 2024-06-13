package com.tracnghiem.demo.Service;

import com.tracnghiem.demo.DTO.Role.RoleCreateForm;
import com.tracnghiem.demo.DTO.Role.RoleUpdateForm;
import com.tracnghiem.demo.Entity.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IRoleService {
    public Page<Role> getAllRoles(Pageable pageable);

    Optional<Role> getRoleById(Long id);

    public void createRole(RoleCreateForm form);

    public void updateRole(RoleUpdateForm form);

    Role updateRole(Long id, RoleUpdateForm form);

    public void deleteRole(Long id);
}
