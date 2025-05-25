package com.eecplise.api.request.service;

import com.eecplise.api.request.dto.FipeMarcaDTO;
import com.eecplise.api.request.entity.fipe.Marca;
import com.eecplise.api.request.repository.fipe.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.eecplise.api.request.repository.fipe.TipoVeiculoRepository;

import java.util.Arrays;

@Service
public class FipeService {

    @Value("${api.invertexto.token}")
    private String token;

    private final RestTemplate restTemplate;
    private final MarcaRepository marcaRepository;
    private final TipoVeiculoRepository tipoVeiculoRepository;

    public FipeService(RestTemplate restTemplate, MarcaRepository marcaRepository, TipoVeiculoRepository tipoVeiculoRepository) {
        this.restTemplate = restTemplate;
        this.marcaRepository = marcaRepository;
        this.tipoVeiculoRepository = tipoVeiculoRepository;
    }

    public void importarMarcasPorTipo(int tipoVeiculo) {
        String url = String.format("https://api.invertexto.com/v1/fipe/brands/%d?token=%s", tipoVeiculo, token);
        FipeMarcaDTO[] marcas = restTemplate.getForObject(url, FipeMarcaDTO[].class);

        if (marcas != null) {
            Arrays.stream(marcas).forEach(dto -> {
                Marca marca = new Marca();
                marca.setCodigo(dto.getCodigo());
                marca.setNome(dto.getNome());
                marca.setTipoVeiculo(tipoVeiculoRepository.findById(tipoVeiculo).orElseThrow(() -> new IllegalArgumentException("Tipo de veículo não encontrado: " + tipoVeiculo)   ));
                marcaRepository.save(marca);
            });
        }
    }
}
