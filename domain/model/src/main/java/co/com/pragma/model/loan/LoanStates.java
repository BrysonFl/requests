package co.com.pragma.model.loan;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum LoanStates {

    PENDING("Pendiente de revisión");

    private final String value;

}
