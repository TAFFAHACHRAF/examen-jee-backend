package com.taffah.springjwt.services;

import com.taffah.springjwt.dtos.ReservationDTO;
import com.taffah.springjwt.exceptions.ProductNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface ReservationService {
    ReservationDTO saveReservation(ReservationDTO ReservationDTO);
    ReservationDTO updateReservation(Long id,ReservationDTO ReservationDTO) throws ProductNotFoundException;
    Page<ReservationDTO> getReservations(Pageable pageable);
    ReservationDTO getReservationById(Long id) throws ProductNotFoundException;
    void deleteReservation(Long id) throws ProductNotFoundException;
}
