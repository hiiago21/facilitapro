package br.com.facilitapro.infrastructure.domain.user;

import br.com.facilitapro.infrastructure.domain.user.adress.AdressEntity;
import br.com.facilitapro.infrastructure.domain.user.telephone.TelephoneEntity;
import br.com.facilitapro.utils.JwtUtils;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode()
@Entity(name = "user_person")
public class UserEntity {
    @Id
    @Column(name = "id")
    @UuidGenerator
    private String id;
    private String fullName;
    private String nickName;
    private LocalDate birthDate;
    private String email;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private TelephoneEntity telephone;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private AdressEntity adress;
    private String socialSecurityNumber;
    private String password;
    private String planSigned;
    private String aboutMe;
    private String userIncluded;
    private LocalDateTime dateIncluded;

    @PrePersist
    public void preInclusao() {
        this.userIncluded = JwtUtils.buscarUsuario();
        this.dateIncluded = LocalDateTime.now();
    }
}
