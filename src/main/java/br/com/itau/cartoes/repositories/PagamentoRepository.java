package br.com.itau.cartoes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.itau.cartoes.models.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> 
{	
	@Query(value = "select * from pagamento where cartao_id = :cartaoId", nativeQuery = true)
	List<Pagamento> findPagamentoByCartaoId(int cartaoId);
}

