package com.example.pathologieapp.domaine;

public class IndexSante {
    private final int valeur;

    public IndexSante(int valeur) {
        if (valeur <= 0) {
            throw new IllegalArgumentException("L'index de santé doit être strictement positif.");
        }
        this.valeur = valeur;
    }

    public int getValeur() {
        return valeur;
    }
}
