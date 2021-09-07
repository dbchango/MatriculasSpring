package espe.edu.matriculacion.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import espe.edu.matriculacion.entities.Cuenta;
import espe.edu.matriculacion.entities.Matricula;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Repository
public class CuentaRep implements ICuentaRep {

    @Value("${espe.edu.apiMatriculas}")
    private String baseUri;

    @Value("${espe.edu.apiMatriculasToken}")
    private String token;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private static final HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();

    @Override
    public Cuenta existsById(Long id) {
        return null;
    }

    @Override
    public Cuenta save(Cuenta cuenta) throws JsonProcessingException, ExecutionException, InterruptedException {
        String reqBody = objectMapper.writeValueAsString(cuenta);
        HttpRequest req = HttpRequest.newBuilder(URI.create(baseUri+"/api/cuentas"))
                .header("Authorization","Bearer "+token)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(cuenta))).build();
        CompletableFuture<HttpResponse<String>> response = client.sendAsync(req, HttpResponse.BodyHandlers.ofString());
        String body = response.get().body();
        System.out.println(objectMapper.readValue(response.get().body(), Cuenta.class));
        return objectMapper.readValue(response.get().body(), Cuenta.class);

    }
}
