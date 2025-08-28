package co.com.pragma.model.loan;

import java.math.BigInteger;
import java.time.LocalDate;

public record UserResponse(BigInteger id, String name, String lastname, LocalDate dateBirthday, String address, String phone, String email, Integer baseSalary) {
}
