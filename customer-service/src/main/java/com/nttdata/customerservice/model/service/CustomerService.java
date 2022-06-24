package com.nttdata.customerservice.model.service;

import com.nttdata.customerservice.model.document.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {
    Flux<Customer> findAll();
    Mono<Customer> create(Customer customer);
    Mono<Customer> findById(String  id);
    Mono<Customer> update(Customer customer);
    Mono<Boolean> existsById(String  id);
    Mono<Void> delete(String  id);
}
