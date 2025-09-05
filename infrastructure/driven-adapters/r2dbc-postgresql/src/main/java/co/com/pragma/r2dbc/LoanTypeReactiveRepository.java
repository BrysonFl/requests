package co.com.pragma.r2dbc;

import co.com.pragma.r2dbc.entity.LoanEntity;
import co.com.pragma.r2dbc.entity.LoanTypesEntity;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.math.BigInteger;

public interface LoanTypeReactiveRepository extends ReactiveCrudRepository<LoanTypesEntity, BigInteger>, ReactiveQueryByExampleExecutor<LoanEntity> {
}
