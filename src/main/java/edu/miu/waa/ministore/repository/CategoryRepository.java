package edu.miu.waa.ministore.repository;

import org.springframework.data.repository.CrudRepository;

import edu.miu.waa.ministore.domain.ProductCategory;

public interface CategoryRepository extends CrudRepository<ProductCategory,Long> {


}
