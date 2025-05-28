package com.eecplise.api.request.service;

import com.eecplise.api.request.dto.FipeMarcaDTO;
import com.eecplise.api.request.entity.fipe.Marca;
import com.eecplise.api.request.entity.fipe.TipoVeiculo;
import com.eecplise.api.request.repository.fipe.MarcaRepository;
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

    public FipeService(RestTemplate restTemplate,
                   MarcaRepository marcaRepository,
                   TipoVeiculoRepository tipoVeiculoRepository) {
        this.restTemplate = restTemplate;
        this.marcaRepository = marcaRepository;
        this.tipoVeiculoRepository = tipoVeiculoRepository;
    }

    public void importarMarcasPorTipo(int tipoVeiculoId) {
        String url = String.format("https://api.invertexto.com/v1/fipe/brands/%d?token=%s", tipoVeiculoId, token);
        FipeMarcaDTO[] marcas = restTemplate.getForObject(url, FipeMarcaDTO[].class);
    
        TipoVeiculo tipoVeiculo = tipoVeiculoRepository.findById(tipoVeiculoId)
            .orElseThrow(() -> new RuntimeException("Tipo de veículo não encontrado: " + tipoVeiculoId));
    
            
            Arrays.stream(marcas).forEach(dto -> {
                if (marcaRepository.findByCodigoAndTipoId(dto.getCodigo(), tipoVeiculo.getId()).isEmpty()) {
                Marca marca = new Marca();
                marca.setCodigo(dto.getCodigo());
                marca.setNome(dto.getNome());
                marca.setTipoVeiculo(tipoVeiculo);
                marcaRepository.save(marca);
            });
        }
    }
}
