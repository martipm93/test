package com.slashmobility.test.service;


import com.slashmobility.test.web.dto.CityDTO;
import com.slashmobility.test.web.dto.ProductDTO;
import com.slashmobility.test.web.dto.ProductInputDTO;
import com.slashmobility.test.web.dto.ProductTypeDTO;

import java.util.List;

public interface ProductService {

    ProductDTO create(ProductInputDTO productInputDTO);

    ProductDTO update(ProductInputDTO productInputDTO, Long id);

    ProductDTO findById(Long id);

    List<ProductDTO> findAll();

    List<ProductDTO> findAllByProductType(ProductTypeDTO productTypeDTO);

    List<ProductDTO> findAllByCity(CityDTO cityDTO);

}
