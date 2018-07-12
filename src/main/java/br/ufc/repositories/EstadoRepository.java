package br.ufc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.domain.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}
