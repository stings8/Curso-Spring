package br.ufc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.domain.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

}
