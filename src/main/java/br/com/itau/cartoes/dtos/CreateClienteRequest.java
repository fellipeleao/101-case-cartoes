package br.com.itau.cartoes.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreateClienteRequest 
{
	@NotBlank
	@Size(min = 3)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
