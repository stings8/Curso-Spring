package br.ufc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
