package org.idxtec.domain.pedido;

import java.time.LocalDate;

public interface PedidoResult {
    
    Long getId();
    
    String getNumero();

    LocalDate getEmissao();
}
