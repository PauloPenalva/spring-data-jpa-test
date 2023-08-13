package org.idxtec.domain.pedidoitem;

import java.util.List;

import org.idxtec.entities.PedidoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long> {
    
    @Query("SELECT i FROM PedidoItem i LEFT JOIN FETCH i.pedido WHERE i.pedido.id = :pedidoId")
    List<PedidoItem> findAllByPedidoIdWithAssociations(@Param("pedidoId") Long pedidoId);


    @Query("SELECT i FROM PedidoItem i WHERE i.pedido.id = :pedidoId")
    List<PedidoItem> findAllByPedidoId(@Param("pedidoId") Long pedidoId);
}
