package org.idxtec.domain.pedido;

import org.idxtec.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query(value = "SELECT id, numero, emissao FROM pedido WHERE id = :pedidoId", nativeQuery = true)
    PedidoResult findByPedidoIdProjection(@Param("pedidoId") Long pedidoId);
    
}
