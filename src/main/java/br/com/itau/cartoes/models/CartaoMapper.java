package br.com.itau.cartoes.models;

import org.springframework.stereotype.Component;

import br.com.itau.cartoes.dtos.CreateCartaoRequest;
import br.com.itau.cartoes.dtos.CreateCartaoResponse;

@Component
public class CartaoMapper 
{
	public Cartao toCartao(CreateCartaoRequest createCartaoRequest)
	{
		Cartao cartao = new Cartao();
		cartao.setNumero(createCartaoRequest.getNumero());
		return cartao;
	}
	
	public CreateCartaoResponse toCreateCartaoResponse(Cartao cartao)
	{
		CreateCartaoResponse clienteCartaoReponse = new CreateCartaoResponse();
		clienteCartaoReponse.setId(cartao.getId());
		clienteCartaoReponse.setNumero(cartao.getNumero());
		clienteCartaoReponse.setAtivo(cartao.isAtivo());
		clienteCartaoReponse.setCliente(cartao.getCliente());
		return clienteCartaoReponse;
	}
}
