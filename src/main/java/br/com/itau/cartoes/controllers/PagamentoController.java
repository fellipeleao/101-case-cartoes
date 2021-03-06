package br.com.itau.cartoes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.cartoes.dtos.ConsultaPagamentoResponse;
import br.com.itau.cartoes.dtos.CreatePagamentoRequest;
import br.com.itau.cartoes.dtos.CreatePagamentoResponse;
import br.com.itau.cartoes.models.Pagamento;
import br.com.itau.cartoes.models.PagamentoMapper;
import br.com.itau.cartoes.services.PagamentoService;

@RestController
public class PagamentoController 
{
	@Autowired
	PagamentoService pagamentoService;
	
	@Autowired
	PagamentoMapper pagamentoMapper;

	@PostMapping("/pagamento")
	@ResponseStatus(HttpStatus.CREATED)
	public CreatePagamentoResponse salvaPagamento(@RequestBody CreatePagamentoRequest createPagamentoRequest)
	{
		Pagamento pagamento = pagamentoMapper.toPagamento(createPagamentoRequest);
		return pagamentoMapper.toCreatePagamentoResponse(pagamentoService.salvaPagamento(pagamento));
	}
	
	@GetMapping("/pagamentos/{id_cartao}")
	@ResponseStatus(HttpStatus.OK)
	public List<ConsultaPagamentoResponse> consultaPagamentos(@PathVariable(value="id_cartao") int cartaoId)
	{
		return pagamentoMapper.toListConsultaPagamentoResponse(pagamentoService.consultaPagamentos(cartaoId));
	}
}
