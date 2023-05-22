package com.taffah.springjwt.mappers;

import com.taffah.springjwt.dtos.PassagerDTO;
import com.taffah.springjwt.models.Passager;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PassagerMapperImpl {
    public PassagerDTO fromPassager(Passager Passager){
        PassagerDTO PassagerDTO=new PassagerDTO();
        BeanUtils.copyProperties(Passager,PassagerDTO);
        return  PassagerDTO;
    }
    public Passager fromPassagerDTO(PassagerDTO PassagerDTO){
        Passager Passager=new Passager();
        BeanUtils.copyProperties(PassagerDTO,Passager);
        return Passager;
    }
    public List<PassagerDTO> toPassagerDTOs(List<Passager> Passagers) {
        return Passagers.stream()
                .map(this::fromPassager)
                .collect(Collectors.toList());
    }
}
