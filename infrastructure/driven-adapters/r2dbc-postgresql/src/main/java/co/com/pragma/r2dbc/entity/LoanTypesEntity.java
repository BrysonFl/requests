package co.com.pragma.r2dbc.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigInteger;

@Setter
@Getter
@Table("loan_type")
public class LoanTypesEntity {

    private @Id BigInteger id;
    private String name;
    private BigInteger minimumAmount;
    private BigInteger maximumAmount;
    private Integer interestRate;
    private Boolean automaticValidation;

}
