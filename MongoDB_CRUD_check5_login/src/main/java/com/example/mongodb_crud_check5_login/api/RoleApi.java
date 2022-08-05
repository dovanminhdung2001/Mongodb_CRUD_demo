package com.example.mongodb_crud_check5_login.api;

import com.example.mongodb_crud_check5_login.model.Role;
import com.example.mongodb_crud_check5_login.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/roles")
public class RoleApi {
    private final RoleService roleService;

    @GetMapping
    public ResponseEntity getAllRole() {
        return ResponseEntity.ok(roleService.getAllRole());
    }

    @PostMapping
    public ResponseEntity createRole(@RequestBody String roleName){
        Role role = roleService.saveRole(roleName);
        URI uri = URI.create("/roles/" + role.getId());

        return ResponseEntity.created(uri).body(role);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteRole (@PathParam(value = "roleId") String roleId) {
        roleService.deleteRole(roleId);
        return ResponseEntity.ok().build();
    }
}
