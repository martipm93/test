package com.slashmobility.test.web.dto;

import javax.validation.constraints.NotNull;

public class ProductTypeDTO {

    @NotNull
    private Long id;
    @NotNull
    private String name;

    public ProductTypeDTO() {}

    public ProductTypeDTO(@NotNull Long id, @NotNull String name) {
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
