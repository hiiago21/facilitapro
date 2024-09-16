package br.com.facilitapro.infrastructure.domain.user.mappers;

import br.com.facilitapro.business.user.bo.TelephoneBO;
import br.com.facilitapro.infrastructure.domain.user.telephone.TelephoneEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TelephoneMapper {
    TelephoneEntity telephoneBoToEntity(TelephoneBO bo);
    TelephoneBO telephonEntityToBo(TelephoneEntity entity);
}
