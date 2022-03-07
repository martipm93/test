package com.slashmobility.test.mapper;

import com.slashmobility.test.entity.ProductEntity;
import com.slashmobility.test.web.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    @Mapping(source = "company.name", target = "companyName")
    ProductDTO toDTO(ProductEntity productEntity);

    List<ProductDTO> toDTOList(List<ProductEntity> productEntityList);

    ProductEntity toEntity(ProductDTO productDTO);

}
