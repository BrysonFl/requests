package co.com.pragma.usecase.loantype;

import co.com.pragma.model.loantype.LoanType;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

public interface ILoanTypeUseCase {

    Mono<LoanType> findById(BigInteger id);
    Mono<LoanType> save(LoanType loanType);

}
