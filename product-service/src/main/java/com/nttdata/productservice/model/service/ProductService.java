package com.nttdata.productservice.model.service;

import com.nttdata.productservice.model.document.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
    Flux<Product> findAll();
    Mono<Product> create(Product product);
    Mono<Product> findById(String  id);
    Mono<Product> update(Product product);
    Mono<Boolean> existsById(String  id);
    Mono<Void> delete(String  id);
}
