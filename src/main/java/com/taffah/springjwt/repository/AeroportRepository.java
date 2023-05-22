package com.taffah.springjwt.repository;

import com.taffah.springjwt.models.Aeroport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AeroportRepository extends JpaRepository<Aeroport,Long> {
    @Query(value = "SELECT * FROM aeroport a WHERE LOWER(p.name) LIKE LOWER(concat('%', :keyword, '%'))", nativeQuery = true)
    List<Aeroport> searchByKeyword(@Param("keyword") String keyword);
}
