package br.com.itau.cartoes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.itau.cartoes.exceptions.CartaoNotFoundException;
import br.com.itau.cartoes.exceptions.CartaoNumberFormatException;
import br.com.itau.cartoes.models.Cartao;
import br.com.itau.cartoes.repositories.CartaoRepository;

@Service
public class CartaoService {
	@Autowired
	CartaoRepository cartaoRepository;
	
	@Autowired
	ClienteService clienteService;
	
	public Cartao salvaCartao(Cartao cartao)
	{   
		return cartaoRepository.save(cartao);
	}
	
	public Cartao ativaCartao(String numero, Cartao cartaoPar)
	{
	    // Verifica número do cartao
	    try {
	        Double.parseDouble(numero);
	    } catch (NumberFormatException nfe) {
	    	throw new CartaoNumberFormatException();
	    }
	    
	    Cartao cartao = cartaoRepository.findByNumero(numero);
	    cartao.setAtivo(cartaoPar.isAtivo());
	    
	    return cartaoRepository.save(cartao);
	}
	
	public Cartao consultaCartao(String numero)
	{
	    // Verifica número do cartao
	    try {
	        Double.parseDouble(numero);
	    } catch (NumberFormatException nfe) {
	    	throw new CartaoNumberFormatException();
	    }
	    
	    Cartao cartao = cartaoRepository.findByNumero(numero);
	    
        if(cartao != null)
        {
                return cartao;
        }
        else
        {
        		throw new CartaoNotFoundException();
        }
	}
	
}
