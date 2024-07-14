package org.example.services;

import com.google.gson.Gson;
import io.github.cdimascio.dotenv.Dotenv;
import org.example.models.Cambio;
import org.example.models.CambioAdapter;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCambio {

    public Cambio consulta(String moedaOrigem, String moedaDestino) throws IOException, InterruptedException {
        Dotenv dotenv = Dotenv.configure().load();

        var key = dotenv.get("API_KEY");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/" + key + "/pair/" + moedaOrigem + "/" + moedaDestino))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        CambioAdapter cambioAdapter = gson.fromJson(response.body(), CambioAdapter.class);
        return new Cambio(cambioAdapter);
    }
}
