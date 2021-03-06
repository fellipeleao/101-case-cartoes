package br.com.itau.cartoes.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.itau.cartoes.exceptions.CartaoNotFoundException;
import br.com.itau.cartoes.exceptions.CartaoNumberFormatException;
import br.com.itau.cartoes.models.Cartao;
import br.com.itau.cartoes.models.Cliente;
import br.com.itau.cartoes.repositories.CartaoRepository;

@Service
public class CartaoService {
	@Autowired
	CartaoRepository cartaoRepository;
	
	@Autowired
	ClienteService clienteService;
	
	public Cartao salvaCartao(Cartao cartao)
	{   
		Cliente cliente = clienteService.consultaCliente(cartao.getCliente().getId());
		cartao.setCliente(cliente);
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
	    
	    Optional<Cartao> cartao = cartaoRepository.findByNumero(numero);
	    
        if(!cartao.isPresent())
        {
        	throw new CartaoNotFoundException();
        }
        
	    cartao.get().setAtivo(cartaoPar.isAtivo());
	    
	    return cartaoRepository.save(cartao.get());
	}
	
	public Cartao consultaCartaoPorNumero(String numero)
	{
	    // Verifica número do cartao
	    try {
	        Double.parseDouble(numero);
	    } catch (NumberFormatException nfe) {
	    	throw new CartaoNumberFormatException();
	    }
	    
	    Optional<Cartao> cartao = cartaoRepository.findByNumero(numero);
	    
        if(!cartao.isPresent())
        {
        	throw new CartaoNotFoundException();
        }
        
        return cartao.get();
	}
	
	public Cartao consultaCartaoPorId(int id)
	{
	    Optional<Cartao> cartao = cartaoRepository.findById(id);
	    
        if(!cartao.isPresent())
        {
        	throw new CartaoNotFoundException();
        }
        
        return cartao.get();
	}
	
}
