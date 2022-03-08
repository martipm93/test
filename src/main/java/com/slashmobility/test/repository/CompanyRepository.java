package com.slashmobility.test.repository;

import com.slashmobility.test.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {

    Optional<CompanyEntity> findFirstByNameEquals(String companyName);

}
