package com.example.relation.entities;

import com.example.relation.entities.converter.MyHStoreConverter;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@jakarta.persistence.Entity
@Table(name = "entities")
public class Entity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String companyId;

    @Column
    private String caEntityId;

    @Column
    private String companyName;

    @Column
    @Convert(converter = MyHStoreConverter.class)
    private Map<String, String> entityType;

    @OneToMany(mappedBy = "entity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Group> groups = new ArrayList<>();

}
