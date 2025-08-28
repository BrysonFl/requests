package co.com.pragma.r2dbc.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigInteger;

@Table("loans")
@Getter
@Setter
@ToString
public class LoanEntity {

    @Id
    private BigInteger id;
    private BigInteger amount;
    private Integer term;
    private String loanType;
    private String state;
    private BigInteger userId;

}
