package com.example.relation.controllers;

import com.example.relation.entities.Entity;
import com.example.relation.entities.Group;
import com.example.relation.repositories.EntityRepository;
import com.example.relation.repositories.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("groups")
@RequiredArgsConstructor
public class GroupController {

    private final GroupRepository groupRepository;

    @GetMapping("{id}")
    public ResponseEntity<?> getGroupById(@PathVariable Long id) {
        Group group = groupRepository.findById(id).orElse(null);
        if(group == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(group);
    }
}
