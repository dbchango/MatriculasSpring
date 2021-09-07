package espe.edu.matriculacion.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import espe.edu.matriculacion.entities.Matricula;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Repository
public class MatriculaRep implements IMatriculacionRep {

    @Value("${espe.edu.apiMatriculas}")
    private String baseUri;

    @Value("${espe.edu.apiMatriculasToken}")
    private String token;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private static final HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
    @Override
    public Matricula save(Matricula matricula) throws IOException, ExecutionException, InterruptedException {
        System.out.println(objectMapper.writeValueAsString(matricula));
        HttpRequest req = HttpRequest.newBuilder(URI.create(baseUri+"/api/matriculas"))
                .header("Authorization","Bearer "+token)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(matricula))).build();
        CompletableFuture<HttpResponse<String>> response = client.sendAsync(req, HttpResponse.BodyHandlers.ofString());
        String body = response.get().body();
        System.out.println(objectMapper.readValue(response.get().body(), Matricula.class));
        return objectMapper.readValue(response.get().body(), Matricula.class);
    }

}
