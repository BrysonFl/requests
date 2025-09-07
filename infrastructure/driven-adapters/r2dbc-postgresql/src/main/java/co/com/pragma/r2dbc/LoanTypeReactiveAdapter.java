package co.com.pragma.r2dbc;

import co.com.pragma.model.loantype.LoanType;
import co.com.pragma.model.loantype.gateways.LoanTypeRepository;
import co.com.pragma.r2dbc.entity.LoanTypesEntity;
import co.com.pragma.r2dbc.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

@Repository
public class LoanTypeReactiveAdapter extends ReactiveAdapterOperations<LoanType, LoanTypesEntity, BigInteger, LoanTypeReactiveRepository> implements LoanTypeRepository {

    public LoanTypeReactiveAdapter(LoanTypeReactiveRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, LoanType.class));
    }

    @Override
    public Mono<LoanType> save(LoanType loanType) {
        return repository.save(toEntity(loanType))
                .flatMap(entity -> Mono.just(toData(entity)));
    }
}
