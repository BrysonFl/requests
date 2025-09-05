package co.com.pragma.consumer;

import co.com.pragma.model.user.User;
import co.com.pragma.model.user.gateways.UserRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class RestConsumer implements UserRepository {

    private final WebClient client;

    @Override
    @CircuitBreaker(name = "findByDni")
    public Mono<User> findByDni(String documentNumber) {
        return client.get()
                .uri("http://localhost:8080/api/v1/usuarios/" + documentNumber)
                .retrieve()
                .bodyToMono(User.class);
    }
}
