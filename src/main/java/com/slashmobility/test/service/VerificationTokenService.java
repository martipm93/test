package com.slashmobility.test.service;

import com.slashmobility.test.entity.UserEntity;
import com.slashmobility.test.entity.VerificationTokenEntity;
import com.slashmobility.test.web.dto.CompanyDTO;

import java.util.List;
import java.util.Optional;

public interface VerificationTokenService {

    VerificationTokenEntity create(UserEntity userEntity);

    Optional<VerificationTokenEntity> findByToken(String token);


}
