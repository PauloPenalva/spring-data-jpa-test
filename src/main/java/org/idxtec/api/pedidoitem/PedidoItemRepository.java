package org.idxtec.api.pedidoitem;

import java.util.List;

import org.idxtec.entities.PedidoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long> {
    
    @Query("SELECT i FROM PedidoItem i LEFT JOIN FETCH i.pedido WHERE i.pedido.id = :pedidoId")
    List<PedidoItem> itensByPedidoId(@Param("pedidoId") Long pedidoId);
}
