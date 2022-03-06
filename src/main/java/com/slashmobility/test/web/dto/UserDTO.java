package com.slashmobility.test.web.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserDTO {
    private Long id;
    private String userName;
    private String password;
    private String email;
    private String firstName;
    private String surName1;
    private String surName2;
    private String nif;
}
