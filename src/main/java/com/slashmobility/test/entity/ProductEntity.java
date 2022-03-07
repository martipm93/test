package com.slashmobility.test.entity;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne()
    @JoinColumn(name = "PRODUCT_TYPE_ID", referencedColumnName = "ID")
    private ProductTypeEntity productType;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "IMAGE_URL")
    private String imageUrl;

    @ManyToOne()
    @JoinColumn(name = "COMPANY_ID", referencedColumnName = "ID")
    private CompanyEntity company;

    public ProductEntity() {}

    public ProductEntity(String name, ProductTypeEntity productType, String description, String imageUrl, CompanyEntity company) {
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

    public ProductTypeEntity getProductType() {
        return productType;
    }

    public void setProductType(ProductTypeEntity productType) {
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

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }
}
