package org.example;

import org.example.models.Cambio;
import org.example.services.ConsultaCambio;
import org.example.services.CalculadoraConversao;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConsultaCambio consultaCambio = new ConsultaCambio();
        var calculadoraConversao = new CalculadoraConversao();
        var scanner = new Scanner(System.in);
        int selecaoMoeda;
        String moedaOrigem = "", moedaDestino = "";
        float montante;
        Cambio cambio;

        {
            System.out.println("""
                    ***********************************************
                    \s
                    Seja Bem-vindo ao Conversor de moeda
                       \s
                        1) Dólar            =>> Peso argentino
                        2) Peso argentino   =>> Dólar
                        3) Dólar            =>> Real Brasileiro
                        4) Real Brasileiro  =>> Dólar
                        5) Dólar            =>> Peso Colombiano
                        6) Peso colombiano  =>> Dólar
                        7) Sair
                       \s
                        Escolha uma opção válida:
                       \s
                    ***********************************************
                   \s""");

            selecaoMoeda = scanner.nextInt();

            System.out.println("Informe o montante: ");
            montante = scanner.nextFloat();

            switch (selecaoMoeda) {
                case 1:
                    moedaOrigem = "USD";
                    moedaDestino = "ARS";
                break;
                case 2:
                    moedaOrigem = "ARS";
                    moedaDestino = "USD";
                break;
                case 3:
                    moedaOrigem = "USD";
                    moedaDestino = "BRL";
                break;
                case 4:
                    moedaOrigem = "BRL";
                    moedaDestino = "USD";
                break;
                case 5:
                    moedaOrigem = "USD";
                    moedaDestino = "COP";
                break;
                case 6:
                    moedaOrigem = "COP";
                    moedaDestino = "USD";
                break;
            }

        } // Menu

        try {
            cambio = consultaCambio.consulta(moedaOrigem,moedaDestino);
            System.out.println(calculadoraConversao.calcular(cambio, montante));
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
