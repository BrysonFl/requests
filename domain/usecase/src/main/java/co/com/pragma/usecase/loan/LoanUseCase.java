package co.com.pragma.usecase.loan;

import co.com.pragma.model.loan.Loan;
import co.com.pragma.model.loan.gateways.LoanRepository;
import co.com.pragma.model.loan.gateways.UserGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class LoanUseCase implements ILoanUserCase {

    private final LoanRepository loanRepository;
    private final UserGateway userGateway;

    @Override
    public Mono<Loan> saveLoan(Loan loan) {
        return loanRepository.saveLoan(loan);
    }
}
