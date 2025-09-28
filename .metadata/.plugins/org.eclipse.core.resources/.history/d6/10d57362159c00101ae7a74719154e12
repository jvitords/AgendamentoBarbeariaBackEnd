package com.barbearia.barbearia.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barbearia.barbearia.application.cliente.ClienteHandler;
import com.barbearia.barbearia.application.cliente.dto.ClienteGetDTO;
import com.barbearia.barbearia.application.cliente.dto.ClientePostDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteHandler clienteHandler;
	
	@PostMapping(value = "/cadastrar")
	public ResponseEntity<ClienteGetDTO> cadastrarUsuario(@Valid @RequestBody ClientePostDTO cliente) throws Exception{
		return ResponseEntity.ok(clienteHandler.cadastrarNovoUsuario(cliente));
	}
}
