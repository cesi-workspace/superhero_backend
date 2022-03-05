package com.lucasmercier.superhero.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "incidents", indexes = {
        @Index(name = "FK_56", columnList = "type"),
        @Index(name = "FK_72", columnList = "location"),
        @Index(name = "FK_62", columnList = "hero")
})
@Getter @Setter
public class Incident implements BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "type", nullable = false)
    private IncidentType type;

    @ManyToOne(optional = false)
    @JoinColumn(name = "location", nullable = false)
    private Location location;

    @ManyToOne(optional = false)
    @JoinColumn(name = "hero", nullable = false)
    private Hero hero;

    @Lob
    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "created_at", nullable = false)
    @CreatedDate
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;
}