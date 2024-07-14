package org.example.services;

import org.example.models.Cambio;

public class CalculadoraConversao {
    public float calcular(Cambio cambio, float montante) {
        return cambio.getTaxaConversao() * montante;
    }
}
