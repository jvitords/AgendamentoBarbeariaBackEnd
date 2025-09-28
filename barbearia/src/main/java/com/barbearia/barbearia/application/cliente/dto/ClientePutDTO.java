package com.barbearia.barbearia.application.cliente.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record ClientePutDTO(
		
		@Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres")
		 String nome,
		 
		 @Size(min = 11, max = 11, message = "O número de telefone deve ter 11 digítos")
		 String telefone,
		 
		 @Email(message = "O e-mail deve ser válido")
		 String email
		) 

{}
