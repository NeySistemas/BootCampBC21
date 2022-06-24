package com.nttdata.customerservice.model.service;

import com.nttdata.customerservice.model.document.CategoryCustomer;
import com.nttdata.customerservice.model.document.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CategoryCustomerService {
    Flux<CategoryCustomer> findAll();
    Mono<CategoryCustomer> create(CategoryCustomer categoryCustomer);
    Mono<CategoryCustomer> findById(String  id);
    Mono<CategoryCustomer> update(CategoryCustomer categoryCustomer);
    Mono<Boolean> existsById(String  id);
    Mono<Void> delete(String  id);
}
