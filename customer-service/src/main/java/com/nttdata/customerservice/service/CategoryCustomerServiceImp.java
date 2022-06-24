package com.nttdata.customerservice.service;

import com.nttdata.customerservice.model.document.CategoryCustomer;
import com.nttdata.customerservice.model.repository.CategoryCustomerRepository;
import com.nttdata.customerservice.model.service.CategoryCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CategoryCustomerServiceImp implements CategoryCustomerService {

    @Autowired
    CategoryCustomerRepository categoryCustomerRepository;

    @Override
    public Flux<CategoryCustomer> findAll() {
        return categoryCustomerRepository.findAll();
    }

    @Override
    public Mono<CategoryCustomer> create(CategoryCustomer categoryCustomer) {
        return categoryCustomerRepository.save(categoryCustomer);
    }

    @Override
    public Mono<CategoryCustomer> findById(String id) {
        return categoryCustomerRepository.findById(id);
    }

    @Override
    public Mono<CategoryCustomer> update(CategoryCustomer categoryCustomer) {
        return categoryCustomerRepository.save(categoryCustomer);
    }

    @Override
    public Mono<Boolean> existsById(String id) {
        return categoryCustomerRepository.existsById(id);
    }

    @Override
    public Mono<Void> delete(String id) {
        return categoryCustomerRepository.deleteById(id);
    }
}
