package com.eecplise.api.request.controller;

import com.eecplise.api.request.service.FipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fipe")
public class FipeController {
    
    private final FipeService fipeService;

    public FipeController(FipeService fipeService) {
        this.fipeService = fipeService;
    }

    @GetMapping("/importar-marcas/{tipo}")
    public ResponseEntity<String> importarMarcas(@PathVariable Integer tipo) {
        return ResponseEntity.ok("Marcas importadas com sucesso para o tipo " + tipo);
    }
}

