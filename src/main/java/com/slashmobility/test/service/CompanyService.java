package com.slashmobility.test.service;

import com.slashmobility.test.web.dto.CompanyDTO;

import java.util.List;

public interface CompanyService {

    CompanyDTO save(CompanyDTO companyDto);

    CompanyDTO update(CompanyDTO companyDTO, Long id);

    CompanyDTO findById(Long id);

    List<CompanyDTO> findAll();

}
