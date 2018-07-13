package br.ufc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
