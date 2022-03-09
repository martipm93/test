package com.slashmobility.test.mapper;

import com.slashmobility.test.entity.ProductEntity;
import com.slashmobility.test.web.dto.ProductDTO;
import com.slashmobility.test.web.dto.ProductInputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    ProductDTO toDTO(ProductEntity productEntity);

    ProductEntity inputToEntity(ProductInputDTO productInputDTO);

    List<ProductDTO> toDTOList(List<ProductEntity> productEntityList);

    ProductEntity toEntity(ProductDTO productDTO);

}
