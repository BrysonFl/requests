package co.com.pragma.r2dbc;

import co.com.pragma.r2dbc.entity.StatesEntity;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.math.BigInteger;

public interface StatesReactiveRepository extends ReactiveCrudRepository<StatesEntity, BigInteger>, ReactiveQueryByExampleExecutor<StatesEntity> {
}
