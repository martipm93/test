package com.slashmobility.test.service;


import com.slashmobility.test.web.dto.CityDTO;
import com.slashmobility.test.web.dto.ProductDTO;
import com.slashmobility.test.web.dto.ProductTypeDTO;

import java.util.List;

public interface ProductService {

    ProductDTO save(ProductDTO productDTO);

    ProductDTO update(ProductDTO productDTO, Long id);

    ProductDTO findById(Long id);

    List<ProductDTO> findAll();

    List<ProductDTO> findAllByProductType(ProductTypeDTO productTypeDTO);

    List<ProductDTO> findAllByCity(CityDTO cityDTO);

}
