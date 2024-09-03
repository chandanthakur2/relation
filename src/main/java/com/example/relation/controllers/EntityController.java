package com.example.relation.controllers;

import com.example.relation.entities.Entity;
import com.example.relation.repositories.EntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("entities")
@RequiredArgsConstructor
public class EntityController {

    private final EntityRepository entityRepository;

    @GetMapping("{id}")
    public ResponseEntity<?> getEntityById(@PathVariable Long id) {
        Entity entity = entityRepository.findById(id).orElse(null);
        if(entity == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(entity);
    }
}
