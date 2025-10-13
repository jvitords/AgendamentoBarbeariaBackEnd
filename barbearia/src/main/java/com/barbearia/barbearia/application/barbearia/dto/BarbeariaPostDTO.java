package com.barbearia.barbearia.application.barbearia.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record BarbeariaPostDTO(
		
		@NotBlank(message = "O nome é obrigatório")
		String nome,
		@NotBlank(message = "O email é obrigatório")
        @Email(message = "O e-mail deve ser válido")
		String email,
		@NotBlank(message = "O password é obrigatório")
		String password,
		@NotBlank(message = "O número é obrigatório")
        @Size(min = 11, max = 11, message = "O número de telefone deve ter 11 digítos")
		String telefone,
		@NotBlank(message = "O CEP é obrigatório")
        @Size(min = 8, max = 8, message = "O número do CEP deve ter 8 digítos")
		String cep
		) {

}
