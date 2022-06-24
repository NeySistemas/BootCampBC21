package com.nttdata.banca.api;

import com.nttdata.banca.model.Service.AsociationService;
import com.nttdata.banca.model.document.Asociation;
import com.nttdata.banca.model.document.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/asociations")
public class AsociationController {

    @Autowired
    AsociationService asociationService;



    @GetMapping
    public Flux<Asociation> findAll(){
        return asociationService.findAll();
    }

    @PostMapping
    public Mono<Asociation> save(@RequestParam("idCustomer") String idCustomer, @RequestParam("idProduct") String idProduct, @RequestParam("amount") float amount){
        return asociationService.create(idCustomer, idProduct, amount);
    }

    @PutMapping
    public Mono<Asociation> update(@RequestBody Asociation asociation){
        return asociationService.update(asociation);
    }

    @GetMapping("/{id}")
    public Mono<Asociation> findById(@PathVariable("id") String  id){

        return asociationService.findById(id);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") String  id){
        return asociationService.delete(id);
    }
}
