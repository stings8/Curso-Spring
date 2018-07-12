package br.ufc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
