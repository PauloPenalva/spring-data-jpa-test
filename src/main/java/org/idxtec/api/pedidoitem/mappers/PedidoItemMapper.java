package org.idxtec.api.pedidoitem.mappers;

import org.idxtec.api.pedidoitem.dtos.PedidoItemDto;
import org.idxtec.entities.PedidoItem;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PedidoItemMapper {
    
    private final ModelMapper modelMapper;

    public PedidoItemDto toDto(PedidoItem t) {
        return modelMapper.map(t, PedidoItemDto.class);
    }
}
