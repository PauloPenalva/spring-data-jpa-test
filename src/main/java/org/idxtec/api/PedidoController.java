package org.idxtec.api;

import java.util.List;

import org.idxtec.entities.Pedido;
import org.idxtec.entities.PedidoItem;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/pedidos")
@RequiredArgsConstructor
public class PedidoController {
    
    private final PedidoRepository repository;

    private final ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public PedidoDto create(@RequestBody PedidoDto dto) {

        Pedido ped = modelMapper.map(dto, Pedido.class);
        ped.getItens().clear();

        dto.getItens().forEach(itemDTO -> {
            PedidoItem item = modelMapper.map(itemDTO, PedidoItem.class);
            ped.addPedidoItem(item);
        });

        return modelMapper.map(repository.save(ped), PedidoDto.class);
    }


    @GetMapping("{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public PedidoDto findOne(@PathVariable Long id) {
            Pedido ped = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Pedido não encontrado."));

            return modelMapper.map(ped, PedidoDto.class);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<PedidoListDto> findAll() {
        return repository.findAll()
            .stream()
            .map(x -> modelMapper.map(x, PedidoListDto.class))
            .toList();
    }

    @PutMapping("{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public PedidoDto update(@PathVariable Long id, @RequestBody PedidoDto dto) {
        repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Pedido não encontrado."));

        Pedido ped = modelMapper.map(dto, Pedido.class);
        ped.getItens().clear();

        dto.getItens().forEach(itemDTO -> {
            PedidoItem item = modelMapper.map(itemDTO, PedidoItem.class);
            ped.addPedidoItem(item);
        });

        return modelMapper.map(repository.save(ped), PedidoDto.class);
    }


    @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
         Pedido ped = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Pedido não encontrado."));

        repository.delete(ped);
    }
}
