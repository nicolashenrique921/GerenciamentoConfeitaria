package confeitaria.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import confeitaria.demo.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}

