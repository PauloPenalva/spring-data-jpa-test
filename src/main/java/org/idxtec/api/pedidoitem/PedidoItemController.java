package org.idxtec.api.pedidoitem;

import java.util.ArrayList;
import java.util.List;

import org.idxtec.api.pedidoitem.dtos.PedidoItemDto;
import org.idxtec.api.pedidoitem.dtos.PedidoItemItemDto;
import org.idxtec.api.pedidoitem.mappers.PedidoItemItemMapper;
import org.idxtec.api.pedidoitem.mappers.PedidoItemMapper;
import org.idxtec.domain.pedidoitem.PedidoItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/pedido-itens")
@RequiredArgsConstructor
public class PedidoItemController {
    
    private final PedidoItemService service;

    private final PedidoItemMapper mapper;
    private final PedidoItemItemMapper itemMapper;

    @GetMapping("/{pedidoId}")
    public List<PedidoItemItemDto> findAllByPedidoId(@PathVariable("pedidoId") Long pedidoId) {
        
        List<PedidoItemItemDto> itensDto = new ArrayList<>();

        service.findAllByPedidoId(pedidoId).forEach(item -> {
            PedidoItemItemDto itemDto = itemMapper.toDto(item);
            itensDto.add(itemDto);
        });

        return itensDto;
    }


    @GetMapping("/join-pedido/{pedidoId}")
    public List<PedidoItemDto> findAllByPedidoIdWithAssociations(@PathVariable("pedidoId") Long pedidoId) {
        List<PedidoItemDto> itensDto = new ArrayList<>();

        service.findAllByPedidoIdWithAssociations(pedidoId).forEach(item -> {
            PedidoItemDto itemDto = mapper.toDto(item);
            itensDto.add(itemDto);
        });

        return itensDto;
    }

}
