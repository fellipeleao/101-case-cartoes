package br.com.itau.cartoes.models;

import org.springframework.stereotype.Component;

import br.com.itau.cartoes.dtos.CreateCartaoRequest;

@Component
public class CartaoMapper 
{
	public Cartao toCartao(CreateCartaoRequest createCartaoRequest)
	{
		Cartao cartao = new Cartao();
		cartao.setNumero(createCartaoRequest.getNumero());
		return cartao;
	}
	
}
