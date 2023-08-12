package org.idxtec.api;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoListDto {
    
    private Long id;

    private String numero;

    private LocalDate emissao;
}
