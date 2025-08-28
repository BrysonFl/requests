package co.com.pragma.model.loan;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LoanTypes {

    CREDIT("Crédito");

    private final String value;

}
