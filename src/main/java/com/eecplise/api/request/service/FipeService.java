package com.eecplise.api.request.service;

import com.eecplise.api.request.dto.FipeMarcaDTO;
import com.eecplise.api.request.dto.FipeModelDTO;
import com.eecplise.api.request.entity.fipe.Marca;
import com.eecplise.api.request.entity.fipe.Model;
import com.eecplise.api.request.entity.fipe.TipoVeiculo;
import com.eecplise.api.request.repository.fipe.MarcaRepository;
import com.eecplise.api.request.repository.fipe.ModelRepository;
import com.eecplise.api.request.repository.fipe.TipoVeiculoRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FipeService {

    @Value("${api.invertexto.token}")
    private String token;

    private final RestTemplate restTemplate;
    private final MarcaRepository marcaRepository;
    private final TipoVeiculoRepository tipoVeiculoRepository;
    private final ModelRepository modelRepository;

    public FipeService(RestTemplate restTemplate,
                       MarcaRepository marcaRepository,
                       TipoVeiculoRepository tipoVeiculoRepository,
                       ModelRepository modelRepository) {
        this.restTemplate = restTemplate;
        this.marcaRepository = marcaRepository;
        this.tipoVeiculoRepository = tipoVeiculoRepository;
        this.modelRepository = modelRepository;
    }

    public void importarMarcasPorTipo(int tipoVeiculoId) {
        String url = String.format("https://api.invertexto.com/v1/fipe/brands/%d?token=%s", tipoVeiculoId, token);
        FipeMarcaDTO[] marcas = restTemplate.getForObject(url, FipeMarcaDTO[].class);

        TipoVeiculo tipoVeiculo = tipoVeiculoRepository.findById(tipoVeiculoId)
                .orElseThrow(() -> new RuntimeException("Tipo de veículo não encontrado: " + tipoVeiculoId));

        Arrays.stream(marcas).forEach(dto -> {
            if (marcaRepository.findByCodigoAndTipoVeiculo_Id(dto.getCodigo(), tipoVeiculo.getId()).isEmpty()) {
                Marca marca = new Marca();
                marca.setCodigo(dto.getCodigo());
                marca.setNome(dto.getNome());
                marca.setTipoVeiculo(tipoVeiculo);
                marcaRepository.save(marca);
            }
        });
    }

    public void importarModelosPorMarca(Long marcaId) {
        Marca marca = marcaRepository.findById(marcaId)
                .orElseThrow(() -> new RuntimeException("Marca não encontrada: " + marcaId));

        String url = String.format("https://api.invertexto.com/v1/fipe/models/%d?token=%s", marcaId, token);
        ResponseEntity<FipeModelDTO[]> response = restTemplate.getForEntity(url, FipeModelDTO[].class);
        FipeModelDTO[] modelos = response.getBody();

        if (modelos == null || modelos.length == 0) {
            throw new RuntimeException("Nenhum modelo retornado para a marca ID " + marcaId);
        }

        List<Model> entities = Arrays.stream(modelos)
                .map(dto -> {
                    Model model = new Model();
                    model.setId(dto.getId());
                    model.setFipeCode(dto.getFipeCode());
                    model.setModel(dto.getModel());
                    model.setYears(dto.getYears());
                    model.setMarca(marca);
                    return model;
                })
                .collect(Collectors.toList());

        modelRepository.saveAll(entities);
    }

    public List<Model> listarModelosPorMarca(Long marcaId) {
        Marca marca = marcaRepository.findById(marcaId)
                .orElseThrow(() -> new RuntimeException("Marca não encontrada: " + marcaId));

        return modelRepository.findByMarca(marca);
    }

}
