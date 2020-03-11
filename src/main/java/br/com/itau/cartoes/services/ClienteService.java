package br.com.itau.cartoes.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.itau.cartoes.exceptions.ClienteNotFoundException;
import br.com.itau.cartoes.models.Cliente;
import br.com.itau.cartoes.repositories.ClienteRepository;

@Service
public class ClienteService 
{
	@Autowired
	ClienteRepository clienteRepository;
	
	public Cliente criaCliente(Cliente cliente)
	{
		return clienteRepository.save(cliente);
	}
	
	public Cliente consultaCliente(int id)
	{
		Optional<Cliente> clienteOptional = clienteRepository.findById(id);
		
		if(!clienteOptional.isPresent())
		{
			throw new ClienteNotFoundException();
		}
			
		return clienteOptional.get();
	}
	

	
}
