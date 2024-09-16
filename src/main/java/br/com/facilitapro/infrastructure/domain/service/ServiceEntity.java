package br.com.facilitapro.infrastructure.domain.service;

import br.com.facilitapro.utils.JwtUtils;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@EqualsAndHashCode
@Entity(name = "service")
public class ServiceEntity {
    @Id
    @Column(name = "id")
    @UuidGenerator
    private String id;
    @OneToMany(mappedBy = "service")
    private List<TaskEntity> tasks;
    private String serviceName;
    private BigDecimal minimumPrice;
    private String userIncluded;
    private LocalDateTime dateIncluded;

    @PrePersist
    public void preInclusao() {
        this.userIncluded = JwtUtils.buscarUsuario();
        this.dateIncluded = LocalDateTime.now();
    }
}
