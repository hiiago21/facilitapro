package br.com.facilitapro.api.user.dto;

import br.com.facilitapro.business.user.bo.PlanSignedEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record UserDTO(String id,
                      String fullName,
                      String nickName,
                      LocalDate birthDate,
                      String email,
                      TelephoneDTO telephone,
                      AdressDTO adress,
                      String socialSecurityNumber,
                      String password,
                      PlanSignedEnum planSigned,
                      String aboutMe,
                      String userIncluded,
                      LocalDateTime dateIncluded) {
}
