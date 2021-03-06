package br.com.itau.cartoes.dtos;

import javax.validation.constraints.NotBlank;
import br.com.itau.cartoes.models.Cliente;

public class CreateCartaoRequest
{
	@NotBlank
	private String numero;
	
	private int clienteId;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getClienteId() {
		return clienteId;
	}

	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}
}
