package br.com.itau.cartoes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.itau.cartoes.models.Cartao;

public interface CartaoRepository extends JpaRepository<Cartao, Integer> 
{	
	@Query(value = "select * from cartao where numero = :numero limit 1", nativeQuery = true)
	Cartao findByNumero(String numero);
}

