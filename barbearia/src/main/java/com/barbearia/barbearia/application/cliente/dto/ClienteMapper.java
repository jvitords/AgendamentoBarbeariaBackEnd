package com.barbearia.barbearia.application.cliente.dto;

import com.barbearia.barbearia.domain.cliente.Cliente;

public class ClienteMapper {

    public static Cliente toEntity(ClientePostDTO dto) {
        Cliente cliente = new Cliente(dto.nome(), dto.email(), dto.telefone());
        cliente.setPassword(dto.password());
        return cliente;
    }

    public static ClienteGetDTO toDTO(Cliente cliente) {
        return new ClienteGetDTO(
                cliente.getId(),
                cliente.getNome(),
                cliente.getTelefone(),
                cliente.getEmail()
        );
    }
}