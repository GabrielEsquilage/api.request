package com.eecplise.api.request.service;

import com.eecplise.api.request.dto.CnpjResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CnpjService {

    @Value("${api.invertexto.token}")
    private String token;

    private final RestTemplate restTemplate;

    @Autowired
    public CnpjService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CnpjResponseDTO consultarCnpj(String cnpj) {
        String url = "https://api.invertexto.com/v1/cnpj/" + cnpj + "?token=" + token;
        return restTemplate.getForObject(url, CnpjResponseDTO.class);
    }
}

