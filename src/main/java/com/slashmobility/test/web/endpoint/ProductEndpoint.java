package com.slashmobility.test.web.endpoint;

import com.slashmobility.test.service.ProductService;
import com.slashmobility.test.web.dto.CityDTO;
import com.slashmobility.test.web.dto.ProductDTO;
import com.slashmobility.test.web.dto.ProductInputDTO;
import com.slashmobility.test.web.dto.ProductTypeDTO;
import com.slashmobility.test.web.endpoint.constants.URLConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = URLConstants.PRODUCT_ROOT)
public class ProductEndpoint {

    private final ProductService productService;

    public ProductEndpoint(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public List<ProductDTO> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping(value = URLConstants.PRODUCT_TYPE_PATH,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public List<ProductDTO> getProductByProductType(@Valid ProductTypeDTO productTypeDTO) {
        return productService.findAllByProductType(productTypeDTO);
    }

    @GetMapping(value = URLConstants.CITY_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public List<ProductDTO> getProductByCity(@Valid CityDTO cityDTO) {
        return productService.findAllByCity(cityDTO);
    }

    @GetMapping(value = URLConstants.ID_PATH_PARAM, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public ProductDTO getProduct(@PathVariable(URLConstants.ID_PARAM) Long id) {
        return productService.findById(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public ProductDTO createProduct(@RequestBody ProductInputDTO productInputDTO) {
        return productService.create(productInputDTO);
    }

    @PutMapping(value = URLConstants.ID_PATH_PARAM, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public ProductDTO updateProduct(@PathVariable(URLConstants.ID_PARAM) Long id,
                                    @RequestBody ProductInputDTO productInputDTO) {
        return productService.update(productInputDTO, id);
    }
}
