package br.com.facilitapro.api.user.dto;

import java.time.LocalDateTime;

public record AdressDTO(Long id,
                        String streetName,
                        String additionalAddress,
                        String number,
                        String cityName,
                        String postalCode,
                        String stateName,
                        String countryName,
                        String userIncluded,
                        LocalDateTime dateIncluded) {
}
