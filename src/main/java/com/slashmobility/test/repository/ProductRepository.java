package com.slashmobility.test.repository;


import com.slashmobility.test.entity.CityEntity;
import com.slashmobility.test.entity.ProductEntity;
import com.slashmobility.test.entity.ProductTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    Optional<ProductEntity> findFirstById(Long id);

    List<ProductEntity> findAllByProductType(ProductTypeEntity productTypeEntity);

    List<ProductEntity> findAllByCompanyCity(CityEntity cityEntity);

}
