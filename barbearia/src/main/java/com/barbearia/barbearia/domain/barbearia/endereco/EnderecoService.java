package com.barbearia.barbearia.domain.barbearia.endereco;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EnderecoService {
	
	private String url = "https://viacep.com.br/ws/{CEP}/json/";

    public Endereco buscarEnderecoPorCep(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, Endereco.class, cep);
    }
}
