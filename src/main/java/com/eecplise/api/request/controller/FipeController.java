package com.eecplise.api.request.controller;

import com.eecplise.api.request.service.FipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fipe")
public class  FipeController {

    private final FipeService fipeService;

    public FipeController(FipeService fipeService) {
        this.fipeService = fipeService;
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
}
