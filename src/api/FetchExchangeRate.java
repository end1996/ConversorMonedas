package api;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FetchExchangeRate {
    public static double getRate (String baseCurrency, String targetCurrency, double ammount) {
        String apiKey = "0c45f81e5ff44e267d13a793";
        URI url = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + baseCurrency + "/" + targetCurrency + "/" + ammount);
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            int statusCode = response.statusCode();
            String responseBody = response.body();

            if (statusCode == 200) {
                JsonElement element = JsonParser.parseString(responseBody);
                JsonObject objectRoot = element.getAsJsonObject();

                return objectRoot.get("conversion_result").getAsDouble();
            } else {
                throw new RuntimeException("Error en la solicitud: Código de estado " + statusCode);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener la tasa de cambio: " + e.getMessage());
        }
    }
}