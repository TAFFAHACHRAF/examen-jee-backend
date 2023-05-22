package com.taffah.springjwt.repository;

import com.taffah.springjwt.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
