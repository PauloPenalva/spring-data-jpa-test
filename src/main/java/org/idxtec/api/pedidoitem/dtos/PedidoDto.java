package org.idxtec.api.pedidoitem.dtos;

import java.time.LocalDate;

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
    
}
