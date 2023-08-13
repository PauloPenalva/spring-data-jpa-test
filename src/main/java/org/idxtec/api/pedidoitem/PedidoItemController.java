package org.idxtec.api.pedidoitem;

import java.util.ArrayList;
import java.util.List;

import org.idxtec.api.pedido.PedidoItemDto;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/pedido-itens")
@RequiredArgsConstructor
public class PedidoItemController {
    
    private final PedidoItemRepository repository;

    private final ModelMapper modelMapper;

    @GetMapping("/{pedidoId}")
    public List<PedidoItemDto> findAll(@PathVariable("pedidoId") Long pedidoId) {
        
        List<PedidoItemDto> itensDto = new ArrayList<>();

        repository.itensByPedidoId(pedidoId).forEach(item -> {
            PedidoItemDto itemDto = modelMapper.map(item, PedidoItemDto.class);
            itensDto.add(itemDto);
        });

        return itensDto;
    }


    @GetMapping("/join-pedido/{pedidoId}")
    public List<PedidoItemDto2> findAllByPedidoId(@PathVariable("pedidoId") Long pedidoId) {
        List<PedidoItemDto2> itensDto = new ArrayList<>();

        repository.itensByPedidoIdJoinPedido(pedidoId).forEach(item -> {
            PedidoItemDto2 itemDto = modelMapper.map(item, PedidoItemDto2.class);
            itensDto.add(itemDto);
        });

        return itensDto;
    }

}
