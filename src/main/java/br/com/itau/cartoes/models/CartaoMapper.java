package br.com.itau.cartoes.models;

import org.springframework.stereotype.Component;

import br.com.itau.cartoes.dtos.AtivaCartaoRequest;
import br.com.itau.cartoes.dtos.AtivaCartaoResponse;
import br.com.itau.cartoes.dtos.ConsultaCartaoResponse;
import br.com.itau.cartoes.dtos.CreateCartaoRequest;
import br.com.itau.cartoes.dtos.CreateCartaoResponse;

@Component
public class CartaoMapper 
{
	public Cartao fromCreateCartaoRequestToCartao(CreateCartaoRequest createCartaoRequest)
	{
		Cartao cartao = new Cartao();
		cartao.setNumero(createCartaoRequest.getNumero());
		
		Cliente cliente = new Cliente();
        cliente.setId(createCartaoRequest.getClienteId());
		
        cartao.setCliente(cliente);
        
		return cartao;
	}
	
	public Cartao fromAtivaCartaoRequestToCartao(AtivaCartaoRequest ativaCartaoRequest)
	{
		Cartao cartao = new Cartao();
		cartao.setAtivo(ativaCartaoRequest.isAtivo());
		return cartao;
	}
	
	public CreateCartaoResponse toCreateCartaoResponse(Cartao cartao)
	{
		CreateCartaoResponse clienteCartaoReponse = new CreateCartaoResponse();
		clienteCartaoReponse.setId(cartao.getId());
		clienteCartaoReponse.setNumero(cartao.getNumero());
		clienteCartaoReponse.setAtivo(cartao.isAtivo());
		clienteCartaoReponse.setClienteId(cartao.getCliente().getId());
		return clienteCartaoReponse;
	}
	
	public AtivaCartaoResponse toAtivaCartaoResponse(Cartao cartao)
	{
		AtivaCartaoResponse ativaCartaoReponse = new AtivaCartaoResponse();
		ativaCartaoReponse.setId(cartao.getId());
		ativaCartaoReponse.setNumero(cartao.getNumero());
		ativaCartaoReponse.setAtivo(cartao.isAtivo());
		ativaCartaoReponse.setClienteId(cartao.getCliente().getId());
		return ativaCartaoReponse;
	}
	
	public ConsultaCartaoResponse toConsultaCartaoResponse(Cartao cartao)
	{
		ConsultaCartaoResponse consultaCartaoReponse = new ConsultaCartaoResponse();
		consultaCartaoReponse.setId(cartao.getId());
		consultaCartaoReponse.setNumero(cartao.getNumero());
		consultaCartaoReponse.setClienteId(cartao.getCliente().getId());
		return consultaCartaoReponse;
	}
	
	
}
