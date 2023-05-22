package com.taffah.springjwt.dtos;
import java.util.List;

public class AvionDTO {
    private Long id;
    private String nom;
    private int nombrePlaces;

    private List<VolDTO> vols;
}
