package com.barbearia.barbearia.domain.cliente;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.barbearia.barbearia.application.cliente.dto.ClienteGetDTO;
import com.barbearia.barbearia.application.cliente.dto.ClienteMapper;
import com.barbearia.barbearia.application.cliente.dto.ClientePostDTO;
import com.barbearia.barbearia.application.cliente.dto.ClientePutDTO;
import com.barbearia.barbearia.domain.cliente.exceptions.ClienteJaCadastrado;
import com.barbearia.barbearia.infraestrutura.repository.ClienteRepositoryJpa;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepositoryJpa clienteRepositoryJpa;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public ClienteService(ClienteRepositoryJpa clienteRepositoryJpa){
		this.clienteRepositoryJpa = clienteRepositoryJpa;
	}
	
	public ClienteGetDTO cadastrarCliente(ClientePostDTO clientePost) throws Exception {
		Optional<Cliente> clienteEncontrado = clienteRepositoryJpa.findByEmail(ClienteMapper.toEntity(clientePost).getEmail());
		if(clienteEncontrado.isPresent()) {
			Cliente cliente = ClienteMapper.toEntity(clientePost);
			throw new ClienteJaCadastrado(cliente.getEmail());
		}

		Cliente cliente = ClienteMapper.toEntity(clientePost);
		cliente.setPassword(passwordEncoder.encode(cliente.getPassword()));
		clienteRepositoryJpa.save(cliente);
		return ClienteMapper.toDTO(cliente);
	}
	
	public ClienteGetDTO atualizarDados(Long idDoUsuarioLogado, ClientePutDTO clientePutDTO) {
	    Cliente cliente = clienteRepositoryJpa.findById(idDoUsuarioLogado)
	            .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

	    boolean nomeBlank = clientePutDTO.nome() == null || clientePutDTO.nome().isBlank();
	    boolean emailBlank = clientePutDTO.email() == null || clientePutDTO.email().isBlank();
	    boolean telefoneBlank = clientePutDTO.telefone() == null || clientePutDTO.telefone().isBlank();

	    if (!nomeBlank) {
	        cliente.setNome(clientePutDTO.nome().trim());
	    }

	    if (!emailBlank) {
	        // Evita duplicar email com outro cliente
	        if (!cliente.getEmail().equalsIgnoreCase(clientePutDTO.email()) &&
	            clienteRepositoryJpa.existsByEmail(clientePutDTO.email())) {
	            throw new IllegalArgumentException("Já existe um cliente com esse email.");
	        }
	        cliente.setEmail(clientePutDTO.email().trim());
	    }

	    if (!telefoneBlank) {
	        cliente.setTelefone(clientePutDTO.telefone().trim());
	    }

	    return ClienteMapper.toDTO(clienteRepositoryJpa.save(cliente));
	}

	
}
