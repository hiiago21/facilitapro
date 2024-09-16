package br.com.facilitapro.infrastructure.domain.service;

import br.com.facilitapro.utils.JwtUtils;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode()
@Entity(name = "task")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal value;
    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private ServiceEntity service;
    private String userIncluded;
    private LocalDateTime dateIncluded;

    @PrePersist
    public void preInclusao() {
        this.userIncluded = JwtUtils.buscarUsuario();
        this.dateIncluded = LocalDateTime.now();
    }
}
