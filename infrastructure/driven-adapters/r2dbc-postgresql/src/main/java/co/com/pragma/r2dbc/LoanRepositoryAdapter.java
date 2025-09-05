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
    public Mono<Loan> save(Loan loan) {
        return repository.save(toEntity(loan))
            .map(this::toData);
    }
}
