package org.idxtec.api.pedido.mappers;

import org.idxtec.api.pedido.dtos.PedidoListDto;
import org.idxtec.entities.Pedido;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PedidoListMapper {
    
    private final ModelMapper modelMapper;

    public PedidoListDto toDto(Pedido t) {
        return modelMapper.map(t, PedidoListDto.class);
    }
}
