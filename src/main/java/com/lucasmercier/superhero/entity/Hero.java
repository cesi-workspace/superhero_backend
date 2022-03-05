package com.lucasmercier.superhero.entity;

import com.lucasmercier.superhero.entity.assembler.ControllerLink;
import com.lucasmercier.superhero.feature.hero.controller.HeroesController;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "heroes", indexes = {
        @Index(name = "FK_46", columnList = "location")
})
@ControllerLink(controller = HeroesController.class)
@Getter @Setter
public class Hero implements BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "location", nullable = false)
    private Location location;

    @Column(name = "phone", nullable = false, length = 100)
    private String phone;

    @OneToMany
    @JoinTable(
            name = "incident_types_heroes_association",
            joinColumns = @JoinColumn(name = "id_hero"),
            inverseJoinColumns = @JoinColumn(name = "id_incident")
    )
    private Set<IncidentType> incidentTypes;
}