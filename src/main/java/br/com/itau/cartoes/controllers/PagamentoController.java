package br.com.itau.cartoes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.cartoes.models.Pagamento;
import br.com.itau.cartoes.services.PagamentoService;

@RestController
public class PagamentoController 
{
	@Autowired
	PagamentoService pagamentoService;

	@PostMapping("/pagamento")
	public ResponseEntity<Pagamento> salvaPagamento(@RequestBody Pagamento pagamento)
	{
		return pagamentoService.salvaPagamento(pagamento);
	}
	
	@GetMapping("/pagamentos/{id_cartao}")
	public ResponseEntity<List<Pagamento>> consultaPagamentos(@PathVariable(value="id_cartao") int cartaoId)
	{
		return pagamentoService.consultaPagamentos(cartaoId);
	}
}
