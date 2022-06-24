package com.nttdata.banca.model.Service;

import com.nttdata.banca.model.document.Asociation;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface AsociationService {
    Flux<Asociation> findAll();
    Mono<Asociation> create(String idCustomer, String idProduct, float amount);
    Mono<Asociation> findById(String  id);
    Mono<Asociation> update(Asociation asociation);
    Mono<Boolean> existsById(String  id);
    Mono<Void> delete(String  id);
}
