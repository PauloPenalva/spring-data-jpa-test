package org.idxtec.api.pedido;

import java.util.List;

import org.idxtec.api.pedido.dtos.PedidoDto;
import org.idxtec.api.pedido.dtos.PedidoListDto;
import org.idxtec.api.pedido.mappers.PedidoListMapper;
import org.idxtec.api.pedido.mappers.PedidoMapper;
import org.idxtec.domain.pedido.PedidoService;
import org.idxtec.entities.Pedido;
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

    private final PedidoService service;

    private final PedidoMapper mapper;
    private final PedidoListMapper listMapper;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public PedidoDto create(@RequestBody PedidoDto dto) {
        Pedido ped = mapper.toEntity(dto);
        service.create(ped);

        return mapper.toDto(ped);
    }

    @GetMapping("{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public PedidoDto findOne(@PathVariable Long id) {
        Pedido ped = service.findOne(id);

        return mapper.toDto(ped);
    }

    @GetMapping("/pedido/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public PedidoDto findByPedidoId(@PathVariable Long id) {
        Pedido ped = service.findByPedidoId(id);

        return mapper.toDto(ped);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<PedidoListDto> findAll() {
        return service.findAll()
                .stream()
                .map(listMapper::toDto)
                .toList();
    }

    @PutMapping("{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public PedidoDto update(@PathVariable Long id, @RequestBody PedidoDto dto) {
        Pedido ped = mapper.toEntity(dto);

        return mapper.toDto(service.update(id, ped));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
