package br.com.facilitapro.infrastructure.domain.serviceorder;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode()
@Entity(name = "service_task")
public class ServiceTasksEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String serviceId;
    private Integer taskId ;
    private String serviceOrderId;
}
