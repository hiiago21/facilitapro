package br.com.facilitapro.infrastructure.domain.service;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CategoryEnum {
    CLEANING(1),
    REPAIRING(2),
    PAINTING(3),
    LAUNDRY(4),
    APPLIANCE(5),
    PLUMBING(6),
    SHIFTING(7),
    BEUATY(8),
    AC_REPARING(9),
    VEHICLE(10),
    ELETRONICS(11),
    MASSAGE(12);

    private final Integer code;
}
