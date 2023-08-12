package org.idxtec.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoItemDto {

    private Long id;

    private String codProduto;

    private Integer quantidade;

    private Double valorUnitario;

    private Double total;

    private Long pedidoId;

}
