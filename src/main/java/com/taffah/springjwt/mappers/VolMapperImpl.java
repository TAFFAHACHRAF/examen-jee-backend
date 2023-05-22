package com.taffah.springjwt.mappers;

import com.taffah.springjwt.dtos.VolDTO;
import com.taffah.springjwt.models.Vol;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VolMapperImpl {
    public VolDTO fromVol(Vol Vol){
        VolDTO VolDTO=new VolDTO();
        BeanUtils.copyProperties(Vol,VolDTO);
        return  VolDTO;
    }
    public Vol fromVolDTO(VolDTO VolDTO){
        Vol Vol=new Vol();
        BeanUtils.copyProperties(VolDTO,Vol);
        return Vol;
    }
    public List<VolDTO> toVolDTOs(List<Vol> Vols) {
        return Vols.stream()
                .map(this::fromVol)
                .collect(Collectors.toList());
    }
}
