package com.nttdata.productservice.api;

import com.nttdata.productservice.model.document.CategoryProduct;
import com.nttdata.productservice.model.document.Product;
import com.nttdata.productservice.model.service.CategoryService;
import com.nttdata.productservice.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/mngproducts")
public class MngProductController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @GetMapping("/cat")
    public Flux<CategoryProduct> findAll(){
        return categoryService.findAll();
    }

    @PostMapping("/cat")
    public Mono<CategoryProduct> save(@RequestBody CategoryProduct categoryProduct){
        return categoryService.create(categoryProduct);
    }

    @PutMapping("/cat")
    public Mono<CategoryProduct> update(@RequestBody CategoryProduct categoryProduct){
        return categoryService.update(categoryProduct);
    }

    @GetMapping("/cat/{id}")
    public Mono<CategoryProduct> findById(@PathVariable("id") String  id){
        return categoryService.findById(id);
    }

    @DeleteMapping("/cat/{id}")
    public Mono<Void> delete(@PathVariable("id") String  id){
        return categoryService.delete(id);
    }

    //metodos pa producto
    @GetMapping("/pro")
    public Flux<Product> _findAll(){
        return productService.findAll();
    }

    @PostMapping("/pro")
    public Mono<Product> _save(@RequestBody Product product){
        return productService.create(product);
    }

    @PutMapping("/pro")
    public Mono<Product> _update(@RequestBody Product product){
        return productService.update(product);
    }

    @GetMapping("/pro/{id}")
    public Mono<Product> _findById(@PathVariable("id") String  id){
        return productService.findById(id);
    }

    @DeleteMapping("/pro/{id}")
    public Mono<Void> _delete(@PathVariable("id") String  id){
        return productService.delete(id);
    }

}
