package br.com.itau.cartoes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
	
	public ResponseEntity<Cartao> ativaCartao(String numero, Cartao cartaoPar)
	{
	    // Verifica numero passado na URL
	    try {
	        Double.parseDouble(numero);
	    } catch (NumberFormatException nfe) {
	    	throw new ResponseStatusException(
	    	          HttpStatus.BAD_REQUEST, "Número de Cartão Inválido");
	    }
	    
	    Cartao cartao = cartaoRepository.findByNumero(numero);
	    cartao.setAtivo(cartaoPar.isAtivo());
	    
		return new ResponseEntity<Cartao>(cartaoRepository.save(cartao), HttpStatus.CREATED);
	}
	
	public ResponseEntity<Cartao> consultaCartao(String numero)
	{
	    // Verifica numero passado na URL
	    try {
	        Double.parseDouble(numero);
	    } catch (NumberFormatException nfe) {
	    	throw new ResponseStatusException(
	    	          HttpStatus.BAD_REQUEST, "Número de Cartão Inválido");
	    }
	    
	    Cartao cartao = cartaoRepository.findByNumero(numero);
	    
        if(cartao != null)
        {
                return new ResponseEntity<Cartao>(cartao, HttpStatus.OK);
        }
        else
        {
        		throw new ResponseStatusException(
        				HttpStatus.NOT_FOUND, "Cartão não encontrado - Verifique o parâmetro Número informado");
        }
	}
	
}
