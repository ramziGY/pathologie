package com.example.pathologieapp.service;

import com.example.pathologieapp.configuration.Configurations;
import com.example.pathologieapp.domaine.IndexSante;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TraitementSanteServiceTest {

    private TraitementSanteService service;

    @BeforeEach
    void setUp() {
        // Je simule une configuration chargée dynamiquement
        Configurations configurations = new Configurations() {
            @Override
            public Map<Integer, String> getPathologies() {
                return Map.of(
                        3, "Cardiologie",
                        5, "Traumatologie"
                );
            }
        };

        service = new TraitementSanteService(configurations);
    }

    @Test
    void testCardiologieSeule() {
        IndexSante index = new IndexSante(3);
        assertEquals(List.of("Cardiologie"), service.determinerUnites(index));
    }

    @Test
    void testTraumatologieSeule() {
        IndexSante index = new IndexSante(5);
        assertEquals(List.of("Traumatologie"), service.determinerUnites(index));
    }

    @Test
    void testMultiplesUnites() {
        IndexSante index = new IndexSante(15);
        assertEquals(List.of("Cardiologie", "Traumatologie"), service.determinerUnites(index));
    }

    @Test
    void testAucuneUnite() {
        IndexSante index = new IndexSante(8);
        assertEquals(List.of("Aucune unité correspondante"), service.determinerUnites(index));
    }
}