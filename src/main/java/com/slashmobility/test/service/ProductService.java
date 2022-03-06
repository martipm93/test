package com.slashmobility.test.service;


import com.slashmobility.test.web.dto.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    ProductDTO save(ProductDTO productDTO);

    Optional<ProductDTO> findById(Long id);

    List<ProductDTO> findAll();

}
