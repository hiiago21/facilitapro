package br.com.facilitapro.business.user.bo;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UserBO {
    private String id;
    private String fullName;
    private String nickName;
    private LocalDate birthDate;
    private String email;
    private TelephoneBO telephone;
    private AdressBO adress;
    private String socialSecurityNumber;
    private String password;
    private PlanSignedEnum planSigned;
    private String aboutMe;
    private String userIncluded;
    private LocalDateTime dateIncluded;
}
