package com.slashmobility.test.web.dto;

import javax.validation.constraints.NotNull;

public class ProductDTO {

    private Long id;
    @NotNull
    private String name;
    @NotNull
    private ProductTypeDTO productType;
    @NotNull
    private String description;
    @NotNull
    private String imageUrl;
    @NotNull
    private CompanyDTO company;

    public ProductDTO() {}

    public ProductDTO(Long id, @NotNull String name, @NotNull ProductTypeDTO productType, @NotNull String description, @NotNull String imageUrl, @NotNull CompanyDTO company) {
        this.id = id;
        this.name = name;
        this.productType = productType;
        this.description = description;
        this.imageUrl = imageUrl;
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductTypeDTO getProductType() {
        return productType;
    }

    public void setProductType(ProductTypeDTO productType) {
        this.productType = productType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public CompanyDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }
}
