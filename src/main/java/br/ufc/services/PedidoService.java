package br.ufc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.domain.Pedido;
import br.ufc.repositories.PedidoRepository;
import br.ufc.services.exception.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	PedidoRepository repository;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: "+ id + ", Tipo: "+ Pedido.class.getName()));
	}
	

}
