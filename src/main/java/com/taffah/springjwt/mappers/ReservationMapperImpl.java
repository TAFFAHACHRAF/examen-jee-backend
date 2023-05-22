package com.taffah.springjwt.mappers;

import com.taffah.springjwt.dtos.ReservationDTO;
import com.taffah.springjwt.models.Reservation;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationMapperImpl {
    public ReservationDTO fromReservation(Reservation Reservation){
        ReservationDTO ReservationDTO=new ReservationDTO();
        BeanUtils.copyProperties(Reservation,ReservationDTO);
        return  ReservationDTO;
    }
    public Reservation fromReservationDTO(ReservationDTO ReservationDTO){
        Reservation Reservation=new Reservation();
        BeanUtils.copyProperties(ReservationDTO,Reservation);
        return Reservation;
    }
    public List<ReservationDTO> toReservationDTOs(List<Reservation> Reservations) {
        return Reservations.stream()
                .map(this::fromReservation)
                .collect(Collectors.toList());
    }
}
