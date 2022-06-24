package com.nttdata.productservice.model.repository;

import com.nttdata.productservice.model.document.CategoryProduct;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends ReactiveMongoRepository<CategoryProduct,String > {
}
