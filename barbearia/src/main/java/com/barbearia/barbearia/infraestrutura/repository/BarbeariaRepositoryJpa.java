package com.barbearia.barbearia.infraestrutura.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbearia.barbearia.domain.barbearia.Barbearia;

public interface BarbeariaRepositoryJpa extends JpaRepository<Barbearia, Long>{
	Optional<Barbearia> findByEmail(String email);
}
