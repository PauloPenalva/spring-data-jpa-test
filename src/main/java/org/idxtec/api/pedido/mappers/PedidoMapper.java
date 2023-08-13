package org.idxtec.api.pedido.mappers;

import org.idxtec.api.pedido.dtos.PedidoDto;
import org.idxtec.entities.Pedido;
import org.idxtec.entities.PedidoItem;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PedidoMapper {
    
    private final ModelMapper modelMapper;

    public PedidoDto toDto(Pedido t) {
        return modelMapper.map(t, PedidoDto.class);
    }

    public Pedido toEntity(PedidoDto d) {
        Pedido ped = modelMapper.map(d, Pedido.class);
        ped.getItens().clear();

        d.getItens().forEach(itemDTO -> {
            PedidoItem item = modelMapper.map(itemDTO, PedidoItem.class);
            ped.addPedidoItem(item);
        });

        return ped;
    }
}
