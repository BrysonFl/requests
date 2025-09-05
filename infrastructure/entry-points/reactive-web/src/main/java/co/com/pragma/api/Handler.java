package co.com.pragma.api;

import co.com.pragma.api.dto.CreateLoanDTO;
import co.com.pragma.api.dto.CreateLoanTypeDTO;
import co.com.pragma.api.mapper.LoanMapper;
import co.com.pragma.model.loan.Loan;
import co.com.pragma.usecase.loan.ILoanUserCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {

    private final LoanMapper mapper;

    private final ILoanUserCase loanUserCase;
    private final ILoanType

    public Mono<ServerResponse> listenPOSTSaveLoan(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(CreateLoanDTO.class)
                .flatMap(request -> loanUserCase.save(mapper.toModel(request), request.customerDocumentNumber()))
                .flatMap(loan -> ServerResponse.status(HttpStatus.CREATED).body(Mono.just(loan), Loan.class));
    }

    public Mono<ServerResponse> listenPOSTSaveLoanType(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(CreateLoanTypeDTO.class)
                .flatMap();
    }

}
