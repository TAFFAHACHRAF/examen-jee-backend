package com.taffah.springjwt.dtos;

import lombok.Data;

@Data
public class TicketDTO {
    private Long id;
    private String numeroPlace;
    private String type;
    private PassagerDTO passager;

    private VolDTO vol;
}
