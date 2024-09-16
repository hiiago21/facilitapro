package br.com.facilitapro.infrastructure.domain.user.adress;

import br.com.facilitapro.infrastructure.domain.user.UserEntity;
import br.com.facilitapro.utils.JwtUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode()
@Entity(name = "adress")
public class AdressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String streetName;
    private String additionalAddress;
    private String number;
    private String cityName;
    private String postalCode;
    private String stateName;
    private String countryName;
    private String userIncluded;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnore
    private UserEntity user;
    private LocalDateTime dateIncluded;

    @PrePersist
    public void preInclusao() {
        this.userIncluded = JwtUtils.buscarUsuario();
        this.dateIncluded = LocalDateTime.now();
    }
}
