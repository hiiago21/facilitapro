package br.com.facilitapro.api.user.mappers;

import br.com.facilitapro.api.user.dto.UserDTO;
import br.com.facilitapro.business.user.bo.UserBO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapperApi {
    UserDTO userBoToDto(UserBO bo);
    UserBO userDtoToBo(UserDTO dto);
}
