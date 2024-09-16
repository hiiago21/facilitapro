package br.com.facilitapro.business.user.bo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TelephoneBO {
    private Long id;
    private String number;
    private String areaCode;
    private String countryCode;
    private String userIncluded;
    private LocalDateTime dateIncluded;
}
