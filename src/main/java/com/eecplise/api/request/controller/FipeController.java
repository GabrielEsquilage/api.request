package com.eecplise.api.request.controller;

import com.eecplise.api.request.dto.FipeAnosResponseDTO;
import com.eecplise.api.request.dto.FipeCodeResponseDTO;
import com.eecplise.api.request.dto.FipeModelDTO;
import com.eecplise.api.request.entity.fipe.Marca;
import com.eecplise.api.request.repository.fipe.MarcaRepository;
import com.eecplise.api.request.service.FipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/fipe")
public class  FipeController {

    private final FipeService fipeService;
    private final MarcaRepository marcaRepository;

    public FipeController(FipeService fipeService, MarcaRepository marcaRepository) {
        this.fipeService = fipeService;
        this.marcaRepository = marcaRepository;
    }


    @GetMapping("/importar-marcas/{tipo}")
    public ResponseEntity<String> importarMarcas(@PathVariable("tipo") int tipo) {
        try {
            fipeService.importarMarcasPorTipo(tipo);
            return ResponseEntity.ok("Marcas importadas com sucesso para o tipo " + tipo + ".");
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body("Erro ao importar marcas: " + ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body("Erro interno ao importar marcas.");
        }
    }

    @GetMapping("/marcas")
    public ResponseEntity<List<Map<String, Object>>> listarMarcas() {
        List<Marca> marcas = marcaRepository.findAll();
        List<Map<String, Object>> resultado = marcas.stream().map(marca -> {
            Map<String, Object> dados = new HashMap<>();
            dados.put("id", marca.getId());
            dados.put("codigo", marca.getCodigo());
            dados.put("nome", marca.getNome());
            return dados;
        }).collect(Collectors.toList());

        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/importar-modelos/{marcaId}")
    public ResponseEntity<String> importarModelos(@PathVariable Long marcaId) {
        try {
            fipeService.importarModelosPorMarca(marcaId);
            return ResponseEntity.ok("Modelos importados com sucesso para a marca ID " + marcaId + ".");
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body("Erro ao importar modelos: " + ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body("Erro interno ao importar modelos.");
        }
    }

    @GetMapping("/modelos/{marcaId}")
    public ResponseEntity<?> listaModelosPOrMarca(@PathVariable Long marcaId){
        try{
            List<FipeModelDTO> modelos = fipeService.listarModelosDTOsPorMarca(marcaId);
            return ResponseEntity.ok(modelos);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Erro ao Buscar Modelos: " + e.getMessage());
        }
    }

    @GetMapping("/precos/{fipeCode}")
    public ResponseEntity<?> consultarPrecosPorFipeCode(@PathVariable("fipeCode") String fipeCode) {
        try {
            FipeAnosResponseDTO response = fipeService.consultarAnosEPrecosPorFipeCode(fipeCode);
            return ResponseEntity.ok(response);
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body("Erro ao consultar preços: " + ex.getMessage());
        }
    }

    @GetMapping("/modelos/buscar")

    public ResponseEntity<?> buscarModelosPorTermo(@RequestParam("termo") String termo) {
        try {
            List<FipeCodeResponseDTO> resultado = fipeService.buscarModelosPorTermo(termo);
            if (resultado.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(resultado);
        
        } catch (Exception e) {
             return ResponseEntity.internalServerError().body("Ocorreu um erro interno ao buscar os modelos.");
        }
    }
}
