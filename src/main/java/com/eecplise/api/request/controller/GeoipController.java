package com.eecplise.api.request.controller;


import com.eecplise.api.request.dto.GeoipResponseDTO;
import com.eecplise.api.request.service.GeoipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/geoip")

public class GeoipController {

    @Autowired
    private GeoipService geoipService;

    @GetMapping("/{ip}")

    public GeoipResponseDTO consultarIp(@PathVariable String ip) {
        return geoipService.consultarIp(ip);
    }

}
