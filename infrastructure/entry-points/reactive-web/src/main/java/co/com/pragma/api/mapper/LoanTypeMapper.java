package co.com.pragma.api.mapper;

import co.com.pragma.api.dto.CreateLoanTypeDTO;
import co.com.pragma.model.loantype.LoanType;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LoanTypeMapper {

    LoanType toModel(CreateLoanTypeDTO request);

}
