package com.example.pathologieapp.controller;

import com.example.pathologieapp.configuration.Configurations;
import com.example.pathologieapp.domaine.IndexSante;
import com.example.pathologieapp.service.TraitementSanteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class IndexSanteController {
    private final TraitementSanteService service;

    public IndexSanteController(TraitementSanteService service) {
        this.service = service;
    }

    @GetMapping("/pathologies")
    public List<String> getPathologies(@RequestParam int index) {
        IndexSante indexSante = new IndexSante(index);
        return service.determinerUnites(indexSante);
    }

}