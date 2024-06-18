package com.aluracursos.conversor;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class consultaApi {
    public void tasasDeCambio(CurrencyCodes baseCurrency, CurrencyCodes targetCurrency, double ValorConvertir){

        String direccion = "https://v6.exchangerate-api.com/v6/6a0c108ae6f955ae3cf40a11//latest/"+baseCurrency;


            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(direccion)).build();
        try{
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            //String json = response.body();
            //System.out.println(json);

            JsonObject jsonObject = new Gson().fromJson(response.body(), JsonObject.class);
            JsonObject tasasConversion = jsonObject.getAsJsonObject("conversion_rates");
            var valorMoneda = tasasConversion.get(String.valueOf(targetCurrency)).getAsDouble();
            var conversion = conversionMoneda(valorMoneda, ValorConvertir);

            System.out.println("el valor " + ValorConvertir +" "+ baseCurrency + " corresponde al valor final de => " +
                    conversion+ " "+targetCurrency);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public double conversionMoneda(double moneda, double valor){
        return moneda * valor;
    }
}
