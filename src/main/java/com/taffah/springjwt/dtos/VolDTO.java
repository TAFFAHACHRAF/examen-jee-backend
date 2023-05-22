package com.taffah.springjwt.dtos;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class VolDTO {
    private Long id;
    private String nom;
    private Date dateDepart;
    private Date dateArrivee;
    private AeroportDTO aeroportDepart;
    private AeroportDTO aeroportDestination;
    private AvionDTO avion;
    private List<ReservationDTO> reservations;
}
