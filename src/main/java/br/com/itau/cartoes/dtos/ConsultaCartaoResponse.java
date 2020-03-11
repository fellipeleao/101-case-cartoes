package br.com.itau.cartoes.dtos;

import br.com.itau.cartoes.models.Cliente;

public class ConsultaCartaoResponse 
{
	private int id;
	private String numero;
	private Cliente cliente;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
