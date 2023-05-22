package com.taffah.springjwt.mappers;

import com.taffah.springjwt.dtos.AeroportDTO;
import com.taffah.springjwt.dtos.AvionDTO;
import com.taffah.springjwt.models.Aeroport;
import com.taffah.springjwt.models.Avion;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AvionMapperImpl {
    public AvionDTO fromAvion(Avion avion){
        AvionDTO avionDTO=new AvionDTO();
        BeanUtils.copyProperties(avion,avionDTO);
        return  avionDTO;
    }
    public Avion fromAvionDTO(AvionDTO avionDTO){
        Avion avion=new Avion();
        BeanUtils.copyProperties(avionDTO,avion);
        return avion;
    }
    public List<AvionDTO> toAvionDTOs(List<Avion> avions) {
        return avions.stream()
                .map(this::fromAvion)
                .collect(Collectors.toList());
    }
}
