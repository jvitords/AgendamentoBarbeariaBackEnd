package com.barbearia.barbearia.infraestrutura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbearia.barbearia.domain.barbearia.Servico;

public interface ServicoRepositoryJpa extends JpaRepository<Servico, Long>{

}
