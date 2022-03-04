package com.slashmobility.test.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
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

}
