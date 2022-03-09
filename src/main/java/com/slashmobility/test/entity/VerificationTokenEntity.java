package com.slashmobility.test.entity;

import javax.persistence.*;

@Entity
@Table(name = "VERIFICATION_TOKEN")
public class VerificationTokenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TOKEN")
    private String token;

    @OneToOne()
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private UserEntity userEntity;


    public VerificationTokenEntity() {}

    public VerificationTokenEntity(String token, UserEntity userEntity) {
        this.token = token;
        this.userEntity = userEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
