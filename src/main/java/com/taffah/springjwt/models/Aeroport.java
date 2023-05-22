package com.taffah.springjwt.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Aeroport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private double longitude;
    private double latitude;
    private double altitude;

    @OneToOne
    private Ville ville;

    @OneToMany
    private List<Vol> vole;

    // Getters and setters
}