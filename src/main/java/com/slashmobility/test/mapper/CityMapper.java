package com.slashmobility.test.mapper;

import com.slashmobility.test.entity.CityEntity;
import com.slashmobility.test.web.dto.CityDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CityMapper {

    CityDTO toDTO(CityEntity cityEntity);

    CityEntity toEntity(CityDTO cityDTO);


}
