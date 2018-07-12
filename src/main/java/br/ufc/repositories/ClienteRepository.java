package br.ufc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
