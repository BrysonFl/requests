package co.com.pragma.r2dbc.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Setter
@Getter
@Table("loan")
@ToString
public class LoanEntity {

    @Id
    private BigInteger id;
    private BigInteger amount;
    private Integer term;

    @Column("id_loan_type")
    private Integer loanType;

    private String email;

    @Column("id_state")
    private Integer state;

    @Column("created_at")
    private LocalDateTime createdAt;

}
