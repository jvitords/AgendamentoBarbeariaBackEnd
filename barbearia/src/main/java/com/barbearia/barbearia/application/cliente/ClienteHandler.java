package com.barbearia.barbearia.application.cliente;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.barbearia.barbearia.application.cliente.dto.ClienteGetDTO;
import com.barbearia.barbearia.application.cliente.dto.ClientePostDTO;
import com.barbearia.barbearia.application.cliente.dto.ClientePutDTO;
import com.barbearia.barbearia.domain.cliente.ClienteService;
import com.barbearia.barbearia.infraestrutura.security.JwtService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class ClienteHandler {
	
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private JwtService jwtService;
	
	public ClienteGetDTO cadastrarNovoUsuario(ClientePostDTO cliente) throws Exception {
		return clienteService.cadastrarCliente(cliente);
	}
	
	public ClienteGetDTO atualizarDados(ClientePutDTO clientePut) {
	    // Pegar request atual
	    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
	            .currentRequestAttributes())
	            .getRequest();

	    // Procurar cookie "jwt"
	    Cookie[] cookies = request.getCookies();
	    String token = null;

	    if (cookies != null) {
	        Optional<Cookie> jwtCookie = Arrays.stream(cookies)
	            .filter(c -> c.getName().equals("jwt"))
	            .findFirst();

	        if (jwtCookie.isPresent()) {
	            token = jwtCookie.get().getValue();
	        }
	    }

	    if (token == null) {
	        throw new RuntimeException("JWT não encontrado");
	    }

	    // Verificar se token é válido
	    if (!jwtService.isTokenValid(token)) {
	        throw new RuntimeException("Token inválido");
	    }

	    // Extrair email do token
	    Long idDoUsuarioLogado = jwtService.extractId(token);
		
		return clienteService.atualizarDados(idDoUsuarioLogado, clientePut);
	}
}
