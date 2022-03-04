package com.slashmobility.test.entity;

import lombok.*;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "USER")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "USER_NAME")
    private String userName;

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


}
