package org.idxtec.api.pedidoitem;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDto2 {
    
    private Long id;

    private String numero;

    private LocalDate emissao;
    
}
