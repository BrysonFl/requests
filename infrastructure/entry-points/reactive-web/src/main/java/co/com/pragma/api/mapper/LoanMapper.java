package co.com.pragma.api.mapper;

import co.com.pragma.api.dto.CreateLoanDTO;
import co.com.pragma.model.loan.Loan;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LoanMapper {

    Loan toModel(CreateLoanDTO dto);

}
