package com.nttdata.customerservice.api;

import com.nttdata.customerservice.model.document.CategoryCustomer;
import com.nttdata.customerservice.model.document.Customer;
import com.nttdata.customerservice.model.service.CategoryCustomerService;
import com.nttdata.customerservice.model.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/mngcustomers")
public class MngCustomerController {

    @Autowired
    CategoryCustomerService categoryCustomerService;
    @Autowired
    CustomerService customerService;

    //metodos para categoria
    @GetMapping("/cat")
    public Flux<CategoryCustomer> findAll(){
        return categoryCustomerService.findAll();
    }

    @PostMapping("/cat")
    public Mono<CategoryCustomer> save(@RequestBody CategoryCustomer categoryCustomer){
        return categoryCustomerService.create(categoryCustomer);
    }

    @PutMapping("/cat")
    public Mono<CategoryCustomer> update(@RequestBody CategoryCustomer categoryCustomer){
        return categoryCustomerService.update(categoryCustomer);
    }

    @GetMapping("/cat/{id}")
    public Mono<CategoryCustomer> findById(@PathVariable("id") String  id){
        return categoryCustomerService.findById(id);
    }

    @DeleteMapping("/cat/{id}")
    public Mono<Void> delete(@PathVariable("id") String  id){
        return categoryCustomerService.delete(id);
    }

    //metodos para customer
    @GetMapping("/cus")
    public Flux<Customer> _findAll(){
        return customerService.findAll();
    }

    @PostMapping("/cus")
    public Mono<Customer> _save(@RequestBody Customer customer){
        return customerService.create(customer);
    }

    @PutMapping("/cus")
    public Mono<Customer> _update(@RequestBody Customer customer){
        return customerService.update(customer);
    }

    @GetMapping("/cus/{id}")
    public Mono<Customer> _findById(@PathVariable("id") String  id){
        return customerService.findById(id);
    }

    @DeleteMapping("/cus/{id}")
    public Mono<Void> _delete(@PathVariable("id") String  id){
        return customerService.delete(id);
    }


}
