package com.example.mongodb_crud_check5_login.service;

import com.example.mongodb_crud_check5_login.model.Role;
import com.example.mongodb_crud_check5_login.repo.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role saveRole(String roleName) {
        Role role = roleRepository.findByName(roleName);

        return role == null
                ? roleRepository.save(new Role(roleName))
                : role;
    }

    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }

    public void deleteRole(String roleId) {
        Role role = roleRepository.findById(roleId).get();

        if (role != null)
            roleRepository.delete(role);

        return;
    }

    public Role findByName(String roleName) {
        return roleRepository.findByName(roleName);
    }
}
