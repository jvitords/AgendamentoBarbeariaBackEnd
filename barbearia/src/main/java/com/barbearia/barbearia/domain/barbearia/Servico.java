package com.barbearia.barbearia.domain.barbearia;

import java.util.HashSet;
import java.util.Set;

import com.barbearia.barbearia.domain.agendamento.Agendamento;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@Entity
@Table(name = "servicos")                                                                                  
public class Servico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Double valor;
	private Integer duracaoAtendimento;
	
	@ManyToMany(mappedBy = "servicos")
	private Set<Agendamento> agendamentos = new HashSet<>();
	
	public Servico(String nome, Double valor, Integer duracaoAtendimento) {
        this.nome = nome;
        this.valor = valor;
        this.duracaoAtendimento = duracaoAtendimento;
    }
}
