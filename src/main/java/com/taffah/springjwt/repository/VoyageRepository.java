package com.taffah.springjwt.repository;

import com.taffah.springjwt.models.Voyage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoyageRepository extends JpaRepository<Voyage,Long> {
}
