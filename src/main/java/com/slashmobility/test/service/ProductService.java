package com.slashmobility.test.service;


import java.util.Optional;

public interface ProductService {

    ProductDTO save(ProductDTO productDTO);

    Optional<ProductDTO> findById(Long id);

    List<ProductDTO> findAll();

}
