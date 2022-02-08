package com.lucasmercier.superhero.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cities", indexes = {
        @Index(name = "FK_75", columnList = "location")
})
@Getter @Setter
public class City {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "location", nullable = false)
    private Location location;

    @Column(name = "password", nullable = false)
    private String password;
}