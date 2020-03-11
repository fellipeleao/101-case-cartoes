package br.com.itau.cartoes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.cartoes.dtos.AtivaCartaoRequest;
import br.com.itau.cartoes.dtos.AtivaCartaoResponse;
import br.com.itau.cartoes.dtos.ConsultaCartaoResponse;
import br.com.itau.cartoes.dtos.CreateCartaoRequest;
import br.com.itau.cartoes.dtos.CreateCartaoResponse;
import br.com.itau.cartoes.models.Cartao;
import br.com.itau.cartoes.models.CartaoMapper;
import br.com.itau.cartoes.services.CartaoService;

@RestController
@RequestMapping("/cartao")
public class CartaoController 
{
	@Autowired
	CartaoService cartaoService;
	
	@Autowired
	CartaoMapper cartaoMapper;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CreateCartaoResponse salvaCartao(@RequestBody CreateCartaoRequest createCartaoRequest)
	{
		Cartao cartao = cartaoMapper.fromCreateCartaoRequestToCartao(createCartaoRequest);
		return cartaoMapper.toCreateCartaoResponse(cartaoService.salvaCartao(cartao));
	}
	
	@PatchMapping("/{numero}")
	@ResponseStatus(HttpStatus.OK)
	public AtivaCartaoResponse ativaCartao(@PathVariable(value="numero") String numero, @RequestBody AtivaCartaoRequest ativaCartaoRequest)
	{
		Cartao cartao = cartaoMapper.fromAtivaCartaoRequestToCartao(ativaCartaoRequest);
		return cartaoMapper.toAtivaCartaoResponse(cartaoService.ativaCartao(numero, cartao));
	}
	
	@GetMapping("/{numero}")
	@ResponseStatus(HttpStatus.OK)
	public ConsultaCartaoResponse consultaCartao(@PathVariable(value="numero") String numero)
	{
		return cartaoMapper.toConsultaCartaoResponse(cartaoService.consultaCartao(numero));
	}
}
