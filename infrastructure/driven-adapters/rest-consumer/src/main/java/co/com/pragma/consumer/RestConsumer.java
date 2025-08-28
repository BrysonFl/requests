package co.com.pragma.consumer;

import co.com.pragma.model.loan.UserResponse;
import co.com.pragma.model.loan.gateways.UserGateway;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class RestConsumer implements UserGateway {

    private final WebClient client;

    @Override
    @CircuitBreaker(name = "findUserByDocumentNumber")
    public Mono<UserResponse> findUserByDocumentNumber(String documentNumber) {
        return client.get()
                .uri("http://localhost:8080/api/v1/usuarios/" + documentNumber)
                .retrieve()
                .bodyToMono(UserResponse.class);
    }
}
