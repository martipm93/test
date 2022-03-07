package com.slashmobility.test.service.impl;

import com.slashmobility.test.entity.CompanyEntity;
import com.slashmobility.test.mapper.CompanyMapper;
import com.slashmobility.test.repository.CompanyRepository;
import com.slashmobility.test.service.CompanyService;
import com.slashmobility.test.web.dto.CompanyDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    public CompanyServiceImpl(CompanyRepository companyRepository, CompanyMapper companyMapper) {
        this.companyRepository = companyRepository;
        this.companyMapper = companyMapper;
    }

    @Override
    public CompanyDTO save(CompanyDTO companyDto) {
        return companyMapper.toDTO(companyRepository.saveAndFlush(companyMapper.toEntity(companyDto)));
    }

    @Override
    public CompanyDTO update(CompanyDTO companyDTO, Long id) {
        if (findById(id) != null) {
            companyDTO.setId(id);
            return save(companyDTO);
        } else {
             //throw new Exception();
            //throw not found exception
            return null;
        }
    }

    @Override
    public CompanyDTO findById(Long id) {
        Optional<CompanyEntity> companyEntity = companyRepository.findById(id);
        return companyEntity.map(companyMapper::toDTO).orElse(null);
    }

    @Override
    public List<CompanyDTO> findAll() {
        return companyMapper.toDTOList(companyRepository.findAll());
    }
}
