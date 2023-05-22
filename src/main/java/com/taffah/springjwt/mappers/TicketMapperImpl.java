package com.taffah.springjwt.mappers;

import com.taffah.springjwt.dtos.TicketDTO;
import com.taffah.springjwt.models.Ticket;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketMapperImpl {
    public TicketDTO fromTicket(Ticket Ticket){
        TicketDTO TicketDTO=new TicketDTO();
        BeanUtils.copyProperties(Ticket,TicketDTO);
        return  TicketDTO;
    }
    public Ticket fromTicketDTO(TicketDTO TicketDTO){
        Ticket Ticket=new Ticket();
        BeanUtils.copyProperties(TicketDTO,Ticket);
        return Ticket;
    }
    public List<TicketDTO> toTicketDTOs(List<Ticket> Tickets) {
        return Tickets.stream()
                .map(this::fromTicket)
                .collect(Collectors.toList());
    }
}
