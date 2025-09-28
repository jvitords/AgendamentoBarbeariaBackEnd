package com.barbearia.barbearia.application;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioLogin(
		
		@NotBlank(message = "Não pode ser nulo")
		@Email(message = "O email deve ser válido")
		String email, 
		@NotBlank(message = "Não pode ser nulo")
		String password
		
		) 

{}
