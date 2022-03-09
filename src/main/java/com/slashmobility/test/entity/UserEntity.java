package com.slashmobility.test.entity;

import javax.persistence.*;

@Entity
@Table(name = "USER")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "SURNAME_1")
    private String surName1;

    @Column(name = "SURNAME_2")
    private String surName2;

    @Column(name = "NIF")
    private String nif;

    @Column(name = "ENABLED")
    private Boolean enabled;

    public UserEntity() {}

    public UserEntity(String username, String password, String email, String firstName, String surName1, String surName2,
                      String nif, Boolean enabled) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.surName1 = surName1;
        this.surName2 = surName2;
        this.nif = nif;
        this.enabled = enabled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
