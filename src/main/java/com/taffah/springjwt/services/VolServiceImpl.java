package com.taffah.springjwt.services;

import com.taffah.springjwt.dtos.VolDTO;
import com.taffah.springjwt.exceptions.ProductNotFoundException;
import com.taffah.springjwt.mappers.VolMapperImpl;
import com.taffah.springjwt.mappers.VilleMapperImpl;
import com.taffah.springjwt.models.Vol;
import com.taffah.springjwt.repository.VolRepository;
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
public class VolServiceImpl implements VolService{
    private VolRepository VolRepository;
    private VolMapperImpl VolMapper;
    private VilleMapperImpl villeMapper;

    @Override
    public VolDTO saveVol(VolDTO VolDTO) {
        log.info("Saving Vol");
        Vol Vol = VolMapper.fromVolDTO(VolDTO);
        Vol savedVol = VolRepository.save(Vol);
        return VolMapper.fromVol(savedVol);
    }

    @Override
    public VolDTO updateVol(Long id, VolDTO VolDTO) throws ProductNotFoundException {
        log.info("Updating Vol with ID: {}", id);
        Vol existingVol = VolRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + id));

        existingVol.setDateArrivee(VolDTO.getDateArrivee());
        existingVol.setNom(VolDTO.getNom());

        Vol updatedVol = VolRepository.save(existingVol);
        return VolMapper.fromVol(updatedVol);
    }

    @Override
    public Page<VolDTO> getVols(Pageable pageable) {
        log.info("Fetching Vols with pagination - page: {}, size: {}", pageable.getPageNumber(), pageable.getPageSize());
        Page<Vol> VolPage = VolRepository.findAll(pageable);
        List<VolDTO> VolDTOS = VolMapper.toVolDTOs(VolPage.getContent());
        return new PageImpl<>(VolDTOS, pageable, VolPage.getTotalElements());
    }

    @Override
    public VolDTO getVolById(Long id) throws ProductNotFoundException {
        log.info("Fetching Product with ID: {}", id);
        Vol Vol = VolRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + id));
        return VolMapper.fromVol(Vol);
    }


    @Override
    public void deleteVol(Long id) throws ProductNotFoundException {
        log.info("Deleting Vol with ID: {}", id);
        Vol Vol = VolRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("User not found with ID: " + id));
        VolRepository.delete(Vol);
    }
}
