package com.taffah.springjwt.services;

import com.taffah.springjwt.dtos.AeroportDTO;
import com.taffah.springjwt.exceptions.ProductNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface AeroportService {
    AeroportDTO saveAeroport(AeroportDTO AeroportDTO);
    AeroportDTO updateAeroport(Long id,AeroportDTO AeroportDTO) throws ProductNotFoundException;
    Page<AeroportDTO> getAeroports(Pageable pageable);
    AeroportDTO getAeroportById(Long id) throws ProductNotFoundException;
    List<AeroportDTO> getAeroportsByKeyword(String keyword);
    void deleteAeroport(Long id) throws ProductNotFoundException;
}
