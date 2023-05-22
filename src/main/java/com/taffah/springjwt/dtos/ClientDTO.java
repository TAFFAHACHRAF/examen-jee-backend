package com.taffah.springjwt.dtos;
import lombok.Data;

import java.util.List;

@Data
public class ClientDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private List<ReservationDTO> reservations;
}
