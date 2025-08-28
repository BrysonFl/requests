package co.com.pragma.r2dbc;

import co.com.pragma.model.loan.Loan;
import co.com.pragma.model.loan.gateways.LoanRepository;
import co.com.pragma.r2dbc.entity.LoanEntity;
import co.com.pragma.r2dbc.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

@Repository
public class LoanRepositoryAdapter extends ReactiveAdapterOperations<Loan, LoanEntity, BigInteger, LoanReactiveRepository> implements LoanRepository {

    public LoanRepositoryAdapter(LoanReactiveRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Loan.class));
    }

    @Override
    public Mono<Loan> saveLoan(Loan loan) {
        LoanEntity loanEntity = toEntity(loan);
        loanEntity.setLoanType("Crédito");
        loanEntity.setState("Pendiente de revisión");

        return repository.save(loanEntity)
                .flatMap(entity -> Mono.just(toData(entity)));
    }
}
