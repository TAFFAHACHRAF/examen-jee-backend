package com.taffah.springjwt.services;

import com.taffah.springjwt.dtos.AeroportDTO;
import com.taffah.springjwt.exceptions.ProductNotFoundException;
import com.taffah.springjwt.mappers.AeroportMapperImpl;
import com.taffah.springjwt.mappers.VilleMapperImpl;
import com.taffah.springjwt.models.Aeroport;
import com.taffah.springjwt.repository.AeroportRepository;
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
public class AeroportServiceImpl implements AeroportService{
    private AeroportRepository aeroportRepository;
    private AeroportMapperImpl aeroportMapper;
    private VilleMapperImpl villeMapper;

    @Override
    public AeroportDTO saveAeroport(AeroportDTO aeroportDTO) {
        log.info("Saving aeroport");
        Aeroport aeroport = aeroportMapper.fromAeroportDTO(aeroportDTO);
        Aeroport savedAeroport = aeroportRepository.save(aeroport);
        return aeroportMapper.fromAeroport(savedAeroport);
    }

    @Override
    public AeroportDTO updateAeroport(Long id, AeroportDTO aeroportDTO) throws ProductNotFoundException {
        log.info("Updating Aeroport with ID: {}", id);
        Aeroport existingAeroport = aeroportRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + id));

        existingAeroport.setLatitude(aeroportDTO.getLatitude());
        existingAeroport.setNom(aeroportDTO.getNom());
        existingAeroport.setLongitude(aeroportDTO.getLongitude());
        existingAeroport.setVille(villeMapper.fromVilleDTO(aeroportDTO.getVille()));

        Aeroport updatedAeroport = aeroportRepository.save(existingAeroport);
        return aeroportMapper.fromAeroport(updatedAeroport);
    }

    @Override
    public Page<AeroportDTO> getAeroports(Pageable pageable) {
        log.info("Fetching aeroports with pagination - page: {}, size: {}", pageable.getPageNumber(), pageable.getPageSize());
        Page<Aeroport> aeroportPage = aeroportRepository.findAll(pageable);
        List<AeroportDTO> aeroportDTOS = aeroportMapper.toAeroportDTOs(aeroportPage.getContent());
        return new PageImpl<>(aeroportDTOS, pageable, aeroportPage.getTotalElements());
    }

    @Override
    public AeroportDTO getAeroportById(Long id) throws ProductNotFoundException {
        log.info("Fetching Product with ID: {}", id);
        Aeroport aeroport = aeroportRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + id));
        return aeroportMapper.fromAeroport(aeroport);
    }

    @Override
    public List<AeroportDTO> getAeroportsByKeyword(String keyword) {
        log.info("Fetching products by keyword: {}", keyword);
        List<Aeroport> products = aeroportRepository.searchByKeyword(keyword);
        return aeroportMapper.toAeroportDTOs(products);
    }

    @Override
    public void deleteAeroport(Long id) throws ProductNotFoundException {
        log.info("Deleting Aeroport with ID: {}", id);
        Aeroport aeroport = aeroportRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("User not found with ID: " + id));
        aeroportRepository.delete(aeroport);
    }
}
