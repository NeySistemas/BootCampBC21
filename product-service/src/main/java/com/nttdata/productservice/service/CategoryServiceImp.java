package com.nttdata.productservice.service;

import com.nttdata.productservice.model.document.CategoryProduct;
import com.nttdata.productservice.model.repository.CategoryRepository;
import com.nttdata.productservice.model.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Flux<CategoryProduct> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Mono<CategoryProduct> create(CategoryProduct categoryProduct) {
        return categoryRepository.save(categoryProduct);
    }

    @Override
    public Mono<CategoryProduct> findById(String id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Mono<CategoryProduct> update(CategoryProduct categoryProduct) {
        return categoryRepository.save(categoryProduct);
    }

    @Override
    public Mono<Boolean> existsById(String id) {
        return categoryRepository.existsById(id);
    }

    @Override
    public Mono<Void> delete(String id) {
        return categoryRepository.deleteById(id);
    }
}
