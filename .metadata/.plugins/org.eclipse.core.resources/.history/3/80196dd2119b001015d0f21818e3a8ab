package com.barbearia.barbearia.infraestrutura.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barbearia.barbearia.domain.cliente.Cliente;
import com.barbearia.barbearia.domain.cliente.ClienteRepository;

@Repository
public interface ClienteRepositoryJpa extends JpaRepository<Cliente, Long>, ClienteRepository{
	
	Optional<Cliente> findByEmail(String emailDoCliente);
}
