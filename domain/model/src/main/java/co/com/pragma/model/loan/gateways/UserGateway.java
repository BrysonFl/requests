package co.com.pragma.model.loan.gateways;

import co.com.pragma.model.loan.UserResponse;
import reactor.core.publisher.Mono;

public interface UserGateway {

    Mono<UserResponse> findUserByDocumentNumber(String documentNumber);

}
