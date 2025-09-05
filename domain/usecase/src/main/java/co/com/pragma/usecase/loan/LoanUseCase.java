package co.com.pragma.usecase.loan;

import co.com.pragma.model.loan.Loan;
import co.com.pragma.model.loan.gateways.LoanRepository;
import co.com.pragma.model.user.gateways.UserRepository;
import co.com.pragma.usecase.exceptions.ConnectionException;
import co.com.pragma.usecase.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class LoanUseCase implements ILoanUserCase {

    private final LoanRepository loanRepository;

    private final UserRepository userRepository;

    @Override
    public Mono<Loan> save(Loan loan, String dni) {
        return userRepository.findByDni(dni)
                .onErrorResume(throwable -> Mono.error(new ConnectionException("Error al conectarse con el servicio de autenticación " + throwable.getMessage())))
                .switchIfEmpty(Mono.error(new NotFoundException("User not found")))
                .flatMap(user -> {
                    loan.setEmail(user.email());
                    loan.setLoanType(loan.getLoanType());
                    return Mono.just(loan);
                })
                .flatMap(user -> loanRepository.save(loan));
    }
}
