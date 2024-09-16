package br.com.facilitapro.business.user;

import br.com.facilitapro.business.user.bo.UserBO;
import br.com.facilitapro.exception.ResourceNotFoundException;
import br.com.facilitapro.infrastructure.domain.user.UserEntity;
import br.com.facilitapro.infrastructure.domain.user.UserRepository;
import br.com.facilitapro.infrastructure.domain.user.adress.AdressEntity;
import br.com.facilitapro.infrastructure.domain.user.adress.AdressRepository;
import br.com.facilitapro.infrastructure.domain.user.mappers.AdressMapper;
import br.com.facilitapro.infrastructure.domain.user.mappers.TelephoneMapper;
import br.com.facilitapro.infrastructure.domain.user.mappers.UserMapper;
import br.com.facilitapro.infrastructure.domain.user.telephone.TelephoneEntity;
import br.com.facilitapro.infrastructure.domain.user.telephone.TelephoneRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final TelephoneRepository telephoneRepository;
    private final AdressRepository adressRepository;
    private final UserMapper mapper;
    private final AdressMapper adressMapper;
    private final TelephoneMapper telephoneMapper;


    public UserBO save(UserBO bo) {
        UserEntity userEntity = mapper.userBoToEntity(bo);
        AdressEntity adressEntity = adressMapper.adressBoToEntity(bo.getAdress());
        TelephoneEntity telephoneEntity = telephoneMapper.telephoneBoToEntity(bo.getTelephone());

        repository.save(userEntity);
        adressEntity.setUser(userEntity);
        telephoneEntity.setUser(userEntity);

        telephoneRepository.save(telephoneEntity);
        adressRepository.save(adressEntity);

        return mapper.userEntityToBo(userEntity);
    }

    public UserBO find(String uuid) {
        return mapper.userEntityToBo(repository.findById(uuid).orElseThrow(ResourceNotFoundException::new));
    }
}
