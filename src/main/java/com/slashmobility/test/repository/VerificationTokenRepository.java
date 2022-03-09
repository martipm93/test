package com.slashmobility.test.repository;

import com.slashmobility.test.entity.VerificationTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VerificationTokenRepository extends JpaRepository<VerificationTokenEntity, Long> {

    VerificationTokenEntity findByToken(String token);

}
