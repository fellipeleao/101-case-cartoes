package br.com.itau.cartoes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.itau.cartoes.models.Pagamento;
import br.com.itau.cartoes.repositories.PagamentoRepository;

@Service
public class PagamentoService 
{
	@Autowired
	PagamentoRepository pagamentoRepository;
	
	public Pagamento salvaPagamento(Pagamento pagamento)
	{
		return pagamentoRepository.save(pagamento);
	}
	
	public List<Pagamento> consultaPagamentos(int cartaoId)
	{  
	    List<Pagamento> listaPagamentos = pagamentoRepository.findPagamentoByCartaoId(cartaoId);
        return listaPagamentos;
	}
	
}
