package api;

import com.google.gson.Gson;
import models.ExchangeRate;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FetchExchangeRate {
    public ExchangeRate getRate (String baseCurrency, String targetCurrency) {
        String apiKey = "0c45f81e5ff44e267d13a793";
        URI url = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + baseCurrency + "/" + targetCurrency);
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            int statusCode = response.statusCode();
            String responseBody = response.body();

            System.out.println("Código de estado HTTP: " + statusCode);

            if (statusCode == 200) {
                return new Gson().fromJson(responseBody, ExchangeRate.class);
            } else {
                throw new RuntimeException("Error en la solicitud: Código de estado " + statusCode);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener la tasa de cambio: " + e.getMessage());
        }
    }
}