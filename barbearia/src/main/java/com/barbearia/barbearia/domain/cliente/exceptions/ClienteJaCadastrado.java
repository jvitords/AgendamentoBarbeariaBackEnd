package com.barbearia.barbearia.domain.cliente.exceptions;

public class ClienteJaCadastrado extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ClienteJaCadastrado(String email){
		super("O email " + email + " já tem cadastro.");
	}

}
