package acciones;

import com.google.gson.Gson;
import modelos.Convercion;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConvirtiendoConexion {

    public Convercion convirtiendoValor(String base, String baseCambio, double valor){

        String apiKey = "";
        String valorCambio = Double.toString(valor);

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"+apiKey+"/pair/"+base+"/"+baseCambio+"/"+valorCambio);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Convercion.class);
        } catch (Exception e) {
            throw new RuntimeException("No pude convertir");
        }
    }
}
