package com.taffah.springjwt.mappers;

import com.taffah.springjwt.dtos.VilleDTO;
import com.taffah.springjwt.models.Ville;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VilleMapperImpl {
    public VilleDTO fromVille(Ville Ville){
        VilleDTO VilleDTO=new VilleDTO();
        BeanUtils.copyProperties(Ville,VilleDTO);
        return  VilleDTO;
    }
    public Ville fromVilleDTO(VilleDTO VilleDTO){
        Ville Ville=new Ville();
        BeanUtils.copyProperties(VilleDTO,Ville);
        return Ville;
    }
    public List<VilleDTO> toVilleDTOs(List<Ville> Villes) {
        return Villes.stream()
                .map(this::fromVille)
                .collect(Collectors.toList());
    }
}
