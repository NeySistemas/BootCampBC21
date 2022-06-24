package com.nttdata.productservice.service;

import com.nttdata.productservice.model.document.Product;
import com.nttdata.productservice.model.repository.ProductRepository;
import com.nttdata.productservice.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Flux<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Mono<Product> create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Mono<Product> findById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public Mono<Product> update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Mono<Boolean> existsById(String id) {
        return productRepository.existsById(id);
    }

    @Override
    public Mono<Void> delete(String id) {
        return productRepository.deleteById(id);
    }
}
