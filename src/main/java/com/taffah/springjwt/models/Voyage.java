package com.taffah.springjwt.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NamedEntityGraph
public class Voyage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateVoyage;
    @OneToMany
    private List<Reservation> reservations;

    @OneToMany
    private List<Vol> vols;

    @OneToMany List<Passager> passagers;
}
