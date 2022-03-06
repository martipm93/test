package com.slashmobility.test.mapper;

import com.slashmobility.test.entity.UserEntity;
import com.slashmobility.test.web.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserDTO toDTO(UserEntity userEntity);

    List<UserDTO> toDTOList(List<UserEntity> userEntityList);

    UserEntity toEntity(UserDTO userDTO);
}
