package br.com.facilitapro.infrastructure.domain.user.mappers;

import br.com.facilitapro.business.user.bo.UserBO;
import br.com.facilitapro.infrastructure.domain.user.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserEntity userBoToEntity(UserBO bo);
    UserBO userEntityToBo(UserEntity entity);
}
