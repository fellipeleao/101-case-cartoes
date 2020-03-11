package br.com.itau.cartoes.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.itau.cartoes.models.Cartao;

public interface CartaoRepository extends CrudRepository<Cartao, Integer> 
{	
	Optional<Cartao> findByNumero(String numero);
	
	Optional<Cartao> findById(int id);
}

