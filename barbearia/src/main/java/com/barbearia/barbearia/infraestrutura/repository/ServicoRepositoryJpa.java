package com.barbearia.barbearia.infraestrutura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbearia.barbearia.domain.barbearia.Servico;
import com.barbearia.barbearia.domain.barbearia.ServicoRepository;

public interface ServicoRepositoryJpa extends JpaRepository<Servico, Long>, ServicoRepository{

}
