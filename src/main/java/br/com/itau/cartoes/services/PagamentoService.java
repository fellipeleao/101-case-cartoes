package br.com.itau.cartoes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.itau.cartoes.models.Cartao;
import br.com.itau.cartoes.models.Pagamento;
import br.com.itau.cartoes.repositories.CartaoRepository;
import br.com.itau.cartoes.repositories.PagamentoRepository;

@Service
public class PagamentoService {
	@Autowired
	PagamentoRepository pagamentoRepository;
	
	public ResponseEntity<Pagamento> salvaPagamento(Pagamento pagamento)
	{
	    if(pagamento.getId() != 0) 
	    {
	    	throw new ResponseStatusException(
	    	          HttpStatus.BAD_REQUEST, "O Id não pode ser definido ao criar um cartão - Remova o parâmetro Id");
	    }
	    
		return new ResponseEntity<Pagamento>(pagamentoRepository.save(pagamento), HttpStatus.CREATED);
	}
	
	public ResponseEntity<List<Pagamento>> consultaPagamentos(int cartaoId)
	{  
	    List<Pagamento> listaPagamentos = pagamentoRepository.findPagamentoByCartaoId(cartaoId);
        return new ResponseEntity<List<Pagamento>>(listaPagamentos, HttpStatus.OK);
	}
	
}
