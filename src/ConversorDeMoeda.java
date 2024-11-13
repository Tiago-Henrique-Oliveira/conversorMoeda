import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConversorDeMoeda {
    private static final String API_KEY = "4fe9abdd02470defc47164c4";
    private static JsonObject conversionRates;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!obterTaxasDeCambio("USD")) {
            System.out.println("Não foi possível obter as taxas de câmbio. O programa será encerrado.");
            return;
        }
        while (true) {
            exibirMenu();
            int escolha = scanner.nextInt();
            scanner.nextLine();
            switch (escolha) {
                case 1:
                    realizarConversao(scanner);
                    break;
                case 2:
                    System.out.println("Saindo... Até logo!");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
    private static void exibirMenu() {
        System.out.println("\n--- Menu de Conversão de Moeda ---");
        System.out.println("1. Realizar conversão de moeda");
        System.out.println("2. Sair");
        System.out.println("Escolha uma opção: ");
    }
    private static boolean obterTaxasDeCambio(String moedaBase) {
        String url = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + moedaBase;
        URI uri = URI.create(url);
        HttpRequest request = HttpRequest.newBuilder().uri(uri).header("Accept", "application/json")
                .build();
        HttpClient client = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                String jsonResponse = response.body();
                JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
                conversionRates = jsonObject.getAsJsonObject("conversion_rates");
                return true;
            } else {
                System.out.println("Erro na requisição. Código de status: " + response.statusCode());
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    private static void realizarConversao(Scanner scanner) {
        System.out.print("Insira a moeda de origem (ex: USD): ");
        String moedaOrigem = scanner.nextLine().toUpperCase();
        System.out.print("Insira a moeda de destino (ex: EUR): ");
        String moedaDestino = scanner.nextLine().toUpperCase();
        System.out.print("Insira o valor a ser convertido: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();
        double valorConvertido = converterMoeda(moedaOrigem, moedaDestino, valor);
        if (valorConvertido != -1) {
            System.out.printf("Valor convertido: %.2f %s%n", valorConvertido, moedaDestino);
        } else {
            System.out.println("Conversão não disponível para as moedas especificadas.");
        }
    }
    private static double converterMoeda(String moedaOrigem, String moedaDestino, double valor) {
        if (conversionRates.has(moedaOrigem) && conversionRates.has(moedaDestino)) {
            double taxaOrigem = conversionRates.get(moedaOrigem).getAsDouble();
            double taxaDestino = conversionRates.get(moedaDestino).getAsDouble();
            return (valor / taxaOrigem) * taxaDestino;
        } else {
            System.out.println("Taxa de câmbio não encontrada para as moedas especificadas.");
            return -1;
        }
    }
}
