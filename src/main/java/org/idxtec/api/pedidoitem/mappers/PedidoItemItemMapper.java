package org.idxtec.api.pedidoitem.mappers;

import org.idxtec.api.pedidoitem.dtos.PedidoItemItemDto;
import org.idxtec.entities.PedidoItem;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PedidoItemItemMapper {
    
    private final ModelMapper modelMapper;

    public PedidoItemItemDto toDto(PedidoItem t) {
        return modelMapper.map(t, PedidoItemItemDto.class);
    }
}

