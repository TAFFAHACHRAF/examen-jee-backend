package com.taffah.springjwt.services;

import com.taffah.springjwt.dtos.VolDTO;
import com.taffah.springjwt.exceptions.ProductNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface VolService {
    VolDTO saveVol(VolDTO VolDTO);
    VolDTO updateVol(Long id,VolDTO VolDTO) throws ProductNotFoundException;
    Page<VolDTO> getVols(Pageable pageable);
    VolDTO getVolById(Long id) throws ProductNotFoundException;
    void deleteVol(Long id) throws ProductNotFoundException;
}
