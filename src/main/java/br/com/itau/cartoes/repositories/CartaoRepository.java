package br.com.itau.cartoes.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.itau.cartoes.models.Cartao;

public interface CartaoRepository extends CrudRepository<Cartao, Integer> 
{	
	@Query(value = "select * from cartao where numero = :numero limit 1", nativeQuery = true)
	Cartao findByNumero(String numero);
}

