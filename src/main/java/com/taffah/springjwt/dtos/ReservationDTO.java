package com.taffah.springjwt.dtos;
import java.util.Date;
import java.util.List;

public class ReservationDTO {
    private Long id;
    private Date date;
    private String siteReservation;
    private ClientDTO client;
    private List<VolDTO> vols;
}
