package co.com.pragma.api.mapper;

import co.com.pragma.api.dto.CreateLoanDTO;
import co.com.pragma.model.loan.Loan;
import co.com.pragma.model.loan.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LoanMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "userResponse.id", target = "userId")
    Loan toModel(CreateLoanDTO dto, UserResponse userResponse);

}
