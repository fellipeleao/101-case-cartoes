package br.com.itau.cartoes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.itau.cartoes.exceptions.CartaoNaoAtivoException;
import br.com.itau.cartoes.models.Cartao;
import br.com.itau.cartoes.models.Pagamento;
import br.com.itau.cartoes.repositories.PagamentoRepository;

@Service
public class PagamentoService 
{
	@Autowired
	PagamentoRepository pagamentoRepository;
	
	@Autowired
	CartaoService cartaoService;
	
	public Pagamento salvaPagamento(Pagamento pagamento)
	{
		Cartao cartao = cartaoService.consultaCartaoPorId(pagamento.getCartaoId());
		
		if(!cartao.isAtivo())
		{
			throw new CartaoNaoAtivoException();
		}
		
		return pagamentoRepository.save(pagamento);
	}
	
	public List<Pagamento> consultaPagamentos(int cartaoId)
	{  
		Cartao cartao = cartaoService.consultaCartaoPorId(cartaoId);
		
		if(!cartao.isAtivo())
		{
			throw new CartaoNaoAtivoException();
		}
		
	    List<Pagamento> listaPagamentos = pagamentoRepository.findPagamentoByCartaoId(cartaoId);
        return listaPagamentos;
	}
	
}
