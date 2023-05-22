package com.taffah.springjwt.repository;

import com.taffah.springjwt.models.Avion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvionRepository extends JpaRepository<Avion,Long> {
}
