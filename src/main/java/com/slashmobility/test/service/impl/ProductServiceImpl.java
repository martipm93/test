package com.slashmobility.test.service.impl;

import com.slashmobility.test.entity.CompanyEntity;
import com.slashmobility.test.entity.ProductEntity;
import com.slashmobility.test.mapper.CityMapper;
import com.slashmobility.test.mapper.ProductMapper;
import com.slashmobility.test.mapper.ProductTypeMapper;
import com.slashmobility.test.repository.CompanyRepository;
import com.slashmobility.test.repository.ProductRepository;
import com.slashmobility.test.service.ProductService;
import com.slashmobility.test.web.dto.CityDTO;
import com.slashmobility.test.web.dto.ProductDTO;
import com.slashmobility.test.web.dto.ProductInputDTO;
import com.slashmobility.test.web.dto.ProductTypeDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CompanyRepository companyRepository;
    private final ProductTypeMapper productTypeMapper;
    private final CityMapper cityMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper,
                              CompanyRepository companyRepository, ProductTypeMapper productTypeMapper, CityMapper cityMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.companyRepository = companyRepository;
        this.productTypeMapper = productTypeMapper;
        this.cityMapper = cityMapper;
    }

    private ProductDTO save(ProductInputDTO productDTO) {
        Optional<CompanyEntity> companyEntity = companyRepository.findFirstByNameEquals(productDTO.getCompanyName());
        if (companyEntity.isPresent()) {
            ProductEntity productEntity = productMapper.inputToEntity(productDTO);
            productEntity.setCompany(companyEntity.get());
            return productMapper.toDTO(productRepository.saveAndFlush(productEntity));
        } else {
            //throw new Exception;
            return null;
        }
    }

    @Override
    public ProductDTO create(ProductInputDTO productDTO) {
        productDTO.setId(null);
        return save(productDTO);
    }

    @Override
    public ProductDTO update(ProductInputDTO productDTO, Long id) {
        if (findById(id) != null) {
            productDTO.setId(id);
            return save(productDTO);
        } else {
            //throw new Exception;
            return null;
        }
    }

    @Override
    public ProductDTO findById(Long id) {
        Optional<ProductEntity> productEntity = productRepository.findById(id);
        return productEntity.map(productMapper::toDTO).orElse(null);
    }

    @Override
    public List<ProductDTO> findAll() {
        return productMapper.toDTOList(productRepository.findAll());
    }

    @Override
    public List<ProductDTO> findAllByProductType(ProductTypeDTO productTypeDTO) {
        return productMapper.toDTOList(productRepository.findAllByProductType(productTypeMapper.toEntity(productTypeDTO)));
    }

    @Override
    public List<ProductDTO> findAllByCity(CityDTO cityDTO) {
        return productMapper.toDTOList(productRepository.findAllByCompanyCity(cityMapper.toEntity(cityDTO)));

    }
}
