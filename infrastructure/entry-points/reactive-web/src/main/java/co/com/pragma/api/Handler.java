package co.com.pragma.api;

import co.com.pragma.api.dto.CreateLoanDTO;
import co.com.pragma.api.mapper.LoanMapper;
import co.com.pragma.model.loan.gateways.UserGateway;
import co.com.pragma.usecase.loan.ILoanUserCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class Handler {

    private final LoanMapper mapper;

    private final ILoanUserCase loanUserCase;
    private final UserGateway userGateway;

    public Mono<ServerResponse> listenPOSTSaveLoan(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(CreateLoanDTO.class)
                .flatMap(request ->
                    userGateway.findUserByDocumentNumber(request.customerDocumentNumber())
                            .onErrorResume(error -> Mono.error(new RuntimeException("Falla en la comunicación con el servicio")))
                            .switchIfEmpty(Mono.error(new RuntimeException("No se encontró ningún usuario con el número de documento " + request.customerDocumentNumber())))
                            .map(user -> mapper.toModel(request, user)))
                .flatMap(loanUserCase::saveLoan)
                .flatMap(loan -> ServerResponse.created(URI.create("")).bodyValue(loan))
                .onErrorResume(error -> ServerResponse.status(HttpStatus.GATEWAY_TIMEOUT).bodyValue(error.getMessage()));
    }

}
