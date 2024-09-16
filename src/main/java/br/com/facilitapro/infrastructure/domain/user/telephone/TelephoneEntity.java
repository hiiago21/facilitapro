package br.com.facilitapro.infrastructure.domain.user.telephone;

import br.com.facilitapro.infrastructure.domain.user.UserEntity;
import br.com.facilitapro.utils.JwtUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode()
@Entity(name = "telephone")
public class TelephoneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private String areaCode;
    private String countryCode;
    private String userIncluded;
    private LocalDateTime dateIncluded;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnore
    private UserEntity user;

    @PrePersist
    public void preInclusao() {
        this.userIncluded = JwtUtils.buscarUsuario();
        this.dateIncluded = LocalDateTime.now();
    }
}
