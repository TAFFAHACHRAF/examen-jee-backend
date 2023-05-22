/*package com.taffah.springjwt.services;

import com.taffah.springjwt.dtos.ReservationDTO;
import com.taffah.springjwt.exceptions.ProductNotFoundException;
import com.taffah.springjwt.mappers.ReservationMapperImpl;
import com.taffah.springjwt.mappers.VilleMapperImpl;
import com.taffah.springjwt.models.Reservation;
import com.taffah.springjwt.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class ReservationServiceImpl implements ReservationService{
    private ReservationRepository reservationRepository;
    private ReservationMapperImpl reservationMapper;
    private VilleMapperImpl villeMapper;

    @Override
    public ReservationDTO saveReservation(ReservationDTO ReservationDTO) {
        log.info("Saving Reservation");
        Reservation Reservation = reservationMapper.fromReservationDTO(ReservationDTO);
        Reservation savedReservation = ReservationRepository.save(Reservation);
        return reservationMapper.fromReservation(savedReservation);
    }

    @Override
    public ReservationDTO updateReservation(Long id, ReservationDTO reservationDTO) throws ProductNotFoundException {
        log.info("Updating Reservation with ID: {}", id);
        Reservation existingReservation = ReservationRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + id));

       // existingReservation.setDate(reservationDTO.ge);

        Reservation updatedReservation = ReservationRepository.save(existingReservation);
        return reservationMapper.fromReservation(updatedReservation);
    }

    @Override
    public Page<ReservationDTO> getReservations(Pageable pageable) {
        log.info("Fetching Reservations with pagination - page: {}, size: {}", pageable.getPageNumber(), pageable.getPageSize());
        Page<Reservation> ReservationPage = ReservationRepository.findAll(pageable);
        List<ReservationDTO> ReservationDTOS = reservationMapper.toReservationDTOs(ReservationPage.getContent());
        return new PageImpl<>(ReservationDTOS, pageable, ReservationPage.getTotalElements());
    }

    @Override
    public ReservationDTO getReservationById(Long id) throws ProductNotFoundException {
        log.info("Fetching Product with ID: {}", id);
        Reservation Reservation = ReservationRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + id));
        return reservationMapper.fromReservation(Reservation);
    }


    @Override
    public void deleteReservation(Long id) throws ProductNotFoundException {
        log.info("Deleting Reservation with ID: {}", id);
        Reservation Reservation = ReservationRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("User not found with ID: " + id));
        ReservationRepository.delete(Reservation);
    }
}
*/