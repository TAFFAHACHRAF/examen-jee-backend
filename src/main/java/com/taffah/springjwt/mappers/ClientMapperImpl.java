package com.taffah.springjwt.mappers;

import com.taffah.springjwt.dtos.ClientDTO;
import com.taffah.springjwt.models.Client;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientMapperImpl {
    public ClientDTO fromClient(Client Client){
        ClientDTO ClientDTO=new ClientDTO();
        BeanUtils.copyProperties(Client,ClientDTO);
        return  ClientDTO;
    }
    public Client fromClientDTO(ClientDTO ClientDTO){
        Client Client=new Client();
        BeanUtils.copyProperties(ClientDTO,Client);
        return Client;
    }
    public List<ClientDTO> toClientDTOs(List<Client> Clients) {
        return Clients.stream()
                .map(this::fromClient)
                .collect(Collectors.toList());
    }
}
