package org.idxtec.api.pedidoitem.dtos;

import lombok.Data;

@Data
public class PedidoItemItemDto {
    
    private Long id;

    private String codProduto;

    private Integer quantidade;

    private Double valorUnitario;

    private Double total;

}
