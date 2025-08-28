package co.com.pragma.model.loan;
import lombok.*;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Loan {

    private BigInteger id;
    private BigInteger amount;
    private Integer term;
    private String loanType;
    private String state;
    private BigInteger userId;

}
