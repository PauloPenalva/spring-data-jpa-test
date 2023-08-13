package org.idxtec.api.pedidoitem.dtos;

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

    private PedidoDto pedido;

}
