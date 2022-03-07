package com.slashmobility.test.web.dto;

import javax.validation.constraints.NotNull;


public class UserDTO {

    private Long id;
    @NotNull
    private String userName;
    @NotNull
    private String password;
    @NotNull
    private String email;
    private String firstName;
    private String surName1;
    private String surName2;
    private String nif;

    public UserDTO() {}

    public UserDTO(Long id, @NotNull String userName, @NotNull String password, @NotNull String email,
                   String firstName, String surName1, String surName2, String nif) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.surName1 = surName1;
        this.surName2 = surName2;
        this.nif = nif;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName1() {
        return surName1;
    }

    public void setSurName1(String surName1) {
        this.surName1 = surName1;
    }

    public String getSurName2() {
        return surName2;
    }

    public void setSurName2(String surName2) {
        this.surName2 = surName2;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

}
