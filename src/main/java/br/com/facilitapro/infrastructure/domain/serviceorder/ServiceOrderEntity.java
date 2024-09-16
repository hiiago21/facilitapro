package br.com.facilitapro.infrastructure.domain.serviceorder;

import br.com.facilitapro.infrastructure.domain.service.PaymentMethodEnum;
import br.com.facilitapro.infrastructure.domain.user.UserEntity;
import br.com.facilitapro.utils.JwtUtils;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@EqualsAndHashCode()
@Entity(name = "service_order")
public class ServiceOrderEntity {
    @Id
    @Column(name = "id")
    @UuidGenerator
    private String id;
    private LocalDateTime dateService;
    private BigDecimal priceService;
    private PaymentMethodEnum paymentMethod;
    private ServiceStatusEnum status;
    @OneToMany(mappedBy = "serviceOrderId")
    private List<ServiceTasksEntity> serviceTasks;
    private String userIncluded;
    private LocalDateTime dateIncluded;
    private LocalDateTime dateUpdate;
    private String userUpdate;
    @OneToOne
    @JoinColumn(name = "contracting_id")
    private UserEntity contractingUser;
    @OneToOne
    @JoinColumn(name = "supplier_id")
    private UserEntity supplierUser;

    @PrePersist
    public void preInclusao() {
        this.userIncluded = JwtUtils.buscarUsuario();
        this.dateIncluded = LocalDateTime.now();
    }

    @PreUpdate
    public void preAtualizacao() {
        this.userUpdate = JwtUtils.buscarUsuario();
        this.dateUpdate = LocalDateTime.now();
    }
}
