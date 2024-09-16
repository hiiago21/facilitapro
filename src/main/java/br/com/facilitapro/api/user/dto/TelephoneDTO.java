package br.com.facilitapro.api.user.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record TelephoneDTO(Long id,
                           String number,
                           String areaCode,
                           String countryCode,
                           String userIncluded,
                           LocalDateTime dateIncluded) {
}
