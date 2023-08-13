package org.idxtec.api.pedido.dtos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDto {
    
    private Long id;

    private String numero;

    private LocalDate emissao;

    private List<PedidoItemDto> itens = new ArrayList<>();
}
