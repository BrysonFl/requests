package co.com.pragma.api.dto;

import java.math.BigInteger;

public record CreateLoanTypeDTO(String name, BigInteger minimumAmount, BigInteger maximumAmount, Integer interestRate) {
}
