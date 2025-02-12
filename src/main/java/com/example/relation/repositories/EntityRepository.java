package com.example.relation.repositories;

import com.example.relation.entities.Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntityRepository extends JpaRepository<Entity, Long> {
}
