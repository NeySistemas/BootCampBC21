package com.nttdata.customerservice.model.repository;

import com.nttdata.customerservice.model.document.CategoryCustomer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryCustomerRepository extends ReactiveMongoRepository<CategoryCustomer,String > {
}
