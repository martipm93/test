package com.slashmobility.test.web.dto;

import javax.validation.constraints.NotNull;

public class CityDTO {

    @NotNull
    private Long id;
    @NotNull
    private String name;

    public CityDTO() {}

    public CityDTO(@NotNull Long id, @NotNull String name) {
        this.id = id;
        this.name = name;
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
}
