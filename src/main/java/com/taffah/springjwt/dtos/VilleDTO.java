package com.taffah.springjwt.dtos;

import lombok.Data;

@Data
public class VilleDTO {
    private Long id;
    private String nom;
    private PaysDTO pays;
}
