package com.taffah.springjwt.repository;

import com.taffah.springjwt.models.Passager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassageRepository extends JpaRepository<Passager,Long> {
}
