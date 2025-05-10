package com.eecplise.api.request.service;

import com.eecplise.api.request.dto.GeoipResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GeoipService {
    @Value("${api.invertexto.token}")
    private String token;

    private final  RestTemplate restTemplate;

    public GeoipService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public GeoipResponseDTO consultarIp(String ip) {
        String url = "https://api.invertexto.com/v1/geoip/" + ip + "?token=" + token;
        return restTemplate.getForObject(url, GeoipResponseDTO.class);
    }
}
