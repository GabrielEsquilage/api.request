package com.eecplise.api.request.controller;

import com.eecplise.api.request.dto.CnpjResponseDTO;
import com.eecplise.api.request.service.CnpjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cnpj")
public class CnpjController {


    @Autowired
    private CnpjService cnpjService;


    @GetMapping("/{cnpj}")
    public CnpjResponseDTO consultarCnpj(@PathVariable String cnpj) {
        return cnpjService.consultarCnpj(cnpj);
    }
}
