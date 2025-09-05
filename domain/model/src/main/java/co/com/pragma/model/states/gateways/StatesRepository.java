package co.com.pragma.model.states.gateways;

import co.com.pragma.model.states.States;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

public interface StatesRepository {

    Mono<States> findById(BigInteger id);

}
