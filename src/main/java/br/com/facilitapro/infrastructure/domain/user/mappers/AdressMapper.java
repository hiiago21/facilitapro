package br.com.facilitapro.infrastructure.domain.user.mappers;

import br.com.facilitapro.business.user.bo.AdressBO;
import br.com.facilitapro.infrastructure.domain.user.adress.AdressEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AdressMapper {
    AdressEntity adressBoToEntity(AdressBO bo);
    AdressBO adressEntityToBo(AdressEntity entity);
}
