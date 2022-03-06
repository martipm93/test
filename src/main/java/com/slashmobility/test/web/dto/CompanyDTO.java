package com.slashmobility.test.web.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CompanyDTO {
    private Long id;
    private String name;
    private String address;
    private Long phoneNumber;
    private CityDTO city;
}
