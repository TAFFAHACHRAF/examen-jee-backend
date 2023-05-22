package com.taffah.springjwt.dtos;
import lombok.Data;

@Data
public class AeroportDTO {
    private Long id;
    private String nom;
    private double longitude;
    private double latitude;
    private double altitude;
    private VilleDTO ville;
}

