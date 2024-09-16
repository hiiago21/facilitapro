package br.com.facilitapro.business.user.bo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AdressBO {
    private Long id;
    private String streetName;
    private String additionalAddress;
    private String number;
    private String cityName;
    private String postalCode;
    private String stateName;
    private String countryName;
    private String userIncluded;
    private LocalDateTime dateIncluded;
}
