package org.idxtec.domain.pedidoitem;

import java.util.List;

import org.idxtec.entities.PedidoItem;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoItemService {
    
    private final PedidoItemRepository repository;


    public List<PedidoItem> findAllByPedidoId(Long pedidoId) {
        List<PedidoItem> items = repository.findAllByPedidoId(pedidoId);
        return items;
    }

    public List<PedidoItem> findAllByPedidoIdWithAssociations(Long pedidoId) {
        List<PedidoItem> items = repository.findAllByPedidoIdWithAssociations(pedidoId);
        return items;
    }
}
