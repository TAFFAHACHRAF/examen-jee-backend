package com.taffah.springjwt.mappers;

import com.taffah.springjwt.dtos.PaysDTO;
import com.taffah.springjwt.models.Pays;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaysMapperImpl {
    public PaysDTO fromPays(Pays Pays){
        PaysDTO PaysDTO=new PaysDTO();
        BeanUtils.copyProperties(Pays,PaysDTO);
        return  PaysDTO;
    }
    public Pays fromPaysDTO(PaysDTO PaysDTO){
        Pays Pays=new Pays();
        BeanUtils.copyProperties(PaysDTO,Pays);
        return Pays;
    }
    public List<PaysDTO> toPaysDTOs(List<Pays> Payss) {
        return Payss.stream()
                .map(this::fromPays)
                .collect(Collectors.toList());
    }
}
