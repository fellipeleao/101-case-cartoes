package br.com.itau.cartoes.dtos;

import javax.validation.constraints.NotBlank;

public class AtivaCartaoRequest 
{
	@NotBlank
	private boolean ativo;

	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
}
