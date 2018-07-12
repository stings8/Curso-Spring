package br.ufc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.domain.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
