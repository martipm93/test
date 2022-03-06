package com.slashmobility.test.service.impl;

import com.slashmobility.test.service.ProductService;
import com.slashmobility.test.web.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public ProductDTO save(ProductDTO productDTO) {
        return null;
    }

    @Override
    public Optional<ProductDTO> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<ProductDTO> findAll() {
        return null;
    }
}
