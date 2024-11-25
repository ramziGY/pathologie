package com.example.pathologieapp.service;

import com.example.pathologieapp.configuration.Configurations;
import com.example.pathologieapp.domaine.IndexSante;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TraitementSanteService {
    private final Map<Integer, String> pathologies;

    public TraitementSanteService(Configurations configurations) {
        this.pathologies = configurations.getPathologies();
    }

    /**
     * Retourne les unités médicales correspondant à un index de santé.
     *
     * @param indexSante Index de santé
     * @return Liste des unités médicales
     */
    public List<String> determinerUnites(IndexSante indexSante) {
        List<String> unites = new ArrayList<>();

        if (pathologies != null) {
            for (Map.Entry<Integer, String> entry : pathologies.entrySet()) {
                if (indexSante.getValeur() % entry.getKey() == 0) {
                    unites.add(entry.getValue());
                }
            }
        }

        return unites.isEmpty() ? List.of("Aucune unité correspondante") : unites;
    }
}
