package com.slashmobility.test.service.impl;

import com.slashmobility.test.entity.UserEntity;
import com.slashmobility.test.entity.VerificationTokenEntity;
import com.slashmobility.test.repository.VerificationTokenRepository;
import com.slashmobility.test.service.VerificationTokenService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class VerificationTokenServiceImpl implements VerificationTokenService {

    private final VerificationTokenRepository verificationTokenRepository;

    public VerificationTokenServiceImpl(VerificationTokenRepository verificationTokenRepository) {
        this.verificationTokenRepository = verificationTokenRepository;
    }

    @Override
    public VerificationTokenEntity create(UserEntity userEntity) {
        VerificationTokenEntity token = new VerificationTokenEntity(UUID.randomUUID().toString(), userEntity);
        return verificationTokenRepository.saveAndFlush(token);
    }

    @Override
    public Optional<VerificationTokenEntity> findByToken(String token) {
        return verificationTokenRepository.findByToken(token);
    }
}
