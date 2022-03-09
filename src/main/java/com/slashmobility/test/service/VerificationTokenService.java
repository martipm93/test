package com.slashmobility.test.service;

import com.slashmobility.test.entity.UserEntity;
import com.slashmobility.test.entity.VerificationTokenEntity;
import com.slashmobility.test.web.dto.CompanyDTO;

import java.util.List;

public interface VerificationTokenService {

    VerificationTokenEntity create(UserEntity userEntity);

    VerificationTokenEntity findByToken(String token);


}
