package com.taffah.springjwt.dtos;
import lombok.Data;

import java.util.List;

@Data
public class PassagerDTO {
    private Long id;
    private String nom;
    private String email;
    private List<TicketDTO> tickets;
}
