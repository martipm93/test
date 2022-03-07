package com.slashmobility.test.web.dto;

import javax.validation.constraints.NotNull;

public class CompanyDTO {

    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String address;
    @NotNull
    private Long phoneNumber;
    @NotNull
    private CityDTO city;

    public CompanyDTO() {}

    public CompanyDTO(Long id, @NotNull String name, @NotNull String address, @NotNull Long phoneNumber, @NotNull CityDTO city) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.city = city;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public CityDTO getCity() {
        return city;
    }

    public void setCity(CityDTO city) {
        this.city = city;
    }
}
