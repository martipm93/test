package com.slashmobility.test.mapper;

import com.slashmobility.test.entity.ProductTypeEntity;
import com.slashmobility.test.web.dto.ProductTypeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductTypeMapper {

    ProductTypeDTO toDTO(ProductTypeEntity productTypeEntity);

    ProductTypeEntity toEntity(ProductTypeDTO productTypeDTO);


}
