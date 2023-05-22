package com.taffah.springjwt.repository;

import com.taffah.springjwt.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
}
