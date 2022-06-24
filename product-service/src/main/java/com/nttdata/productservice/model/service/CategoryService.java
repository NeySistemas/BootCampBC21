package com.nttdata.productservice.model.service;

import com.nttdata.productservice.model.document.CategoryProduct;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CategoryService {
    Flux<CategoryProduct> findAll();
    Mono<CategoryProduct> create(CategoryProduct categoryProduct);
    Mono<CategoryProduct> findById(String  id);
    Mono<CategoryProduct> update(CategoryProduct categoryProduct);
    Mono<Boolean> existsById(String  id);
    Mono<Void> delete(String  id);
}
