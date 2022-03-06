package com.slashmobility.test.service;

import com.slashmobility.test.web.dto.CompanyDTO;

import java.util.List;
import java.util.Optional;

public interface CompanyService {

    CompanyDTO save(CompanyDTO companyDto);

    Optional<CompanyDTO> findById(Long id);

    List<CompanyDTO> findAll();

}
