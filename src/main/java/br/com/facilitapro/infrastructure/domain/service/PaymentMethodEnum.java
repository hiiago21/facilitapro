package br.com.facilitapro.infrastructure.domain.service;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentMethodEnum {
    PAYPAL,
    GOOGLEPAY,
    APPLEPAY,
    CARD,
    CASH_MONEY,
}
