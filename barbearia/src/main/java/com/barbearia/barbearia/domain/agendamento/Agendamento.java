package com.barbearia.barbearia.domain.agendamento;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.barbearia.barbearia.domain.barbearia.Barbearia;
import com.barbearia.barbearia.domain.barbearia.Servico;
import com.barbearia.barbearia.domain.cliente.Cliente;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@NoArgsConstructor
@Entity
@Table(name = "agendamentos")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataHora;
    
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "barbearia_id")
    private Barbearia barbearia;
    
    @ManyToMany
    @JoinTable(name = "agendamento_servico", joinColumns = @JoinColumn(name = "agendamento_id"), inverseJoinColumns = @JoinColumn(name = "servico_id"))
    private Set<Servico> servicos = new HashSet<>();

    public Agendamento(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}