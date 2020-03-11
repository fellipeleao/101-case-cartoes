package br.com.itau.cartoes.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.itau.cartoes.models.Cartao;

public interface CartaoRepository extends CrudRepository<Cartao, Integer> 
{	
	Cartao findByNumero(String numero);
}

