package co.com.pragma.model.user;

import java.math.BigInteger;
import java.time.LocalDate;

public record User(BigInteger id, String documentNumber, String name, String lastname, LocalDate dateBirthday, String address, String phone, String email, Integer baseSalary) {
}
