package com.slashmobility.test.web.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductDTO {
    private Long id;
    private String name;
    private ProductTypeDTO productType;
    private String description;
    private String imageUrl;
    private CompanyDTO company;
}
