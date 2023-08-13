package org.idxtec.domain.pedido;

import java.util.List;

import org.idxtec.entities.Pedido;
import org.idxtec.exceptions.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoService {
    
    private final PedidoRepository repository;

    public Pedido create(Pedido pedido) {

        return repository.save(pedido);
    }

    @Transactional(readOnly = true)
    public Pedido findOne(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new NotFoundException("Pedido não encontrado."));
    }

    @Transactional(readOnly = true)
    public List<Pedido> findAll() {
        return repository.findAll();
    }


    public Pedido update(Long id, Pedido pedido) {
        repository.findById(id)
            .orElseThrow(() -> new NotFoundException("Pedido não encontrado."));

        return repository.save(pedido);
    }


    public void delete(Long id) {
        Pedido ped = repository.findById(id)
        .orElseThrow(() -> new NotFoundException("Pedido não encontrado."));

        repository.delete(ped);
    }
}
