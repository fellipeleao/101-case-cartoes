package br.com.itau.cartoes.dtos;

import javax.validation.constraints.NotBlank;
import br.com.itau.cartoes.models.Cliente;

public class CreateCartaoRequest
{
	@NotBlank
	private String numero;
	
	private Cliente cliente;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
