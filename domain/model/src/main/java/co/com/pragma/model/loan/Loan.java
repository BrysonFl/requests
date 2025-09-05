package co.com.pragma.model.loan;
import lombok.*;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor
@ToString
public class Loan {

    private BigInteger id;
    private BigInteger amount;
    private Integer term;
    private Integer loanType;
    private String email;
    private Integer state;
    private LocalDateTime createdAt;

}
