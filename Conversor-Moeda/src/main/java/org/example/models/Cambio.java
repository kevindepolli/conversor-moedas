package org.example.models;

public class Cambio {

    private String moedaOrigem;
    private String moedaDestino;
    private float taxaConversao;

    public Cambio(CambioAdapter adapter){
        moedaOrigem = adapter.base_code();
        moedaDestino = adapter.target_code();
        taxaConversao = adapter.conversion_rate();
    }



    public String getMoedaOrigem() {
        return moedaOrigem;
    }

    public String getMoedaDestino() {
        return moedaDestino;
    }

    public float getTaxaConversao() {
        return taxaConversao;
    }
}
