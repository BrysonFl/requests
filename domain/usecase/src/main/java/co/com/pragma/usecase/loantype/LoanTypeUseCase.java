package co.com.pragma.usecase.loantype;

import co.com.pragma.model.loantype.LoanType;
import co.com.pragma.model.loantype.gateways.LoanTypeRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

@RequiredArgsConstructor
public class LoanTypeUseCase implements ILoanTypeUseCase {

    private final LoanTypeRepository loanTypeRepository;

    @Override
    public Mono<LoanType> findById(BigInteger id) {
        return null;
    }

    @Override
    public Mono<LoanType> save(LoanType loanType) {
        return loanTypeRepository.save(loanType);
    }
}
