package co.com.pragma.r2dbc;

import co.com.pragma.model.states.States;
import co.com.pragma.model.states.gateways.StatesRepository;
import co.com.pragma.r2dbc.entity.StatesEntity;
import co.com.pragma.r2dbc.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

public class StatesReactiveAdapter extends ReactiveAdapterOperations<States, StatesEntity, BigInteger, StatesReactiveRepository> implements StatesRepository {

    public StatesReactiveAdapter(StatesReactiveRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, States.class));
    }

    @Override
    public Mono<States> findById(BigInteger id) {
        return repository.findById(id)
                .flatMap(entity -> Mono.just(toData(entity)));
    }
}
