package com.taffah.springjwt.mappers;

import com.taffah.springjwt.dtos.AeroportDTO;
import com.taffah.springjwt.models.Aeroport;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AeroportMapperImpl {
    public AeroportDTO fromAeroport(Aeroport aeroport){
        AeroportDTO aeroportDTO=new AeroportDTO();
        BeanUtils.copyProperties(aeroport,aeroportDTO);
        return  aeroportDTO;
    }
    public Aeroport fromAeroportDTO(AeroportDTO aeroportDTO){
        Aeroport aeroport=new Aeroport();
        BeanUtils.copyProperties(aeroportDTO,aeroport);
        return aeroport;
    }
    public List<AeroportDTO> toAeroportDTOs(List<Aeroport> aeroports) {
        return aeroports.stream()
                .map(this::fromAeroport)
                .collect(Collectors.toList());
    }
}
