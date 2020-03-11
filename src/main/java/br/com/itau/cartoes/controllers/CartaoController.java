package br.com.itau.cartoes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.cartoes.dtos.CreateCartaoRequest;
import br.com.itau.cartoes.models.Cartao;
import br.com.itau.cartoes.models.CartaoMapper;
import br.com.itau.cartoes.models.Cliente;
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
	public CreateCartaoResponse salvaCartao(@RequestBody CreateCartaoRequest createCartaoRequest)
	{
		Cartao cartao = cartaoMapper.toCartao(createCartaoRequest);
		cartao = cartaoService.salvaCartao(cartao);
		return cartao;
	}
	
	@PatchMapping("/{numero}")
	public ResponseEntity<Cartao> ativaCartao(@PathVariable(value="numero") String numero, @RequestBody Cartao cartao)
	{
		return cartaoService.ativaCartao(numero, cartao);
	}
	
	@GetMapping("/{numero}")
	public ResponseEntity<Cartao> consultaCartao(@PathVariable(value="numero") String numero)
	{
		return cartaoService.consultaCartao(numero);
	}
}
