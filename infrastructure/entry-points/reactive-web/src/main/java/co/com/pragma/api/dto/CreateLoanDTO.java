package co.com.pragma.api.dto;

import java.math.BigInteger;

public record CreateLoanDTO(String customerDocumentNumber, BigInteger amount, Integer term, Integer loanType) {
}
