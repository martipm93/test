package com.slashmobility.test.service.impl;

import com.slashmobility.test.service.CompanyService;
import com.slashmobility.test.web.dto.CompanyDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Override
    public CompanyDTO save(CompanyDTO companyDto) {
        return null;
    }

    @Override
    public Optional<CompanyDTO> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<CompanyDTO> findAll() {
        return null;
    }
}
