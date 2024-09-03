package com.example.relation.controllers;

import com.example.relation.entities.Role;
import com.example.relation.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleRepository roleRepository;

    @GetMapping("{id}")
    public ResponseEntity<?> getRoleById(@PathVariable Long id) {
        Role role = roleRepository.findById(id).orElse(null);
        if(role == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(role);
    }
}
