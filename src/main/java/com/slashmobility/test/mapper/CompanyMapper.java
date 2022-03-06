package com.slashmobility.test.mapper;

import com.slashmobility.test.entity.CompanyEntity;
import com.slashmobility.test.entity.ProductEntity;
import com.slashmobility.test.web.dto.CompanyDTO;
import com.slashmobility.test.web.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CompanyMapper {

    CompanyDTO toDTO(CompanyEntity companyEntity);

    List<CompanyDTO> toDTOList(List<CompanyEntity> companyEntityList);

    CompanyEntity toEntity(CompanyDTO companyDTO);


}
