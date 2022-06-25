package com.nttdata.banca.service;

import com.nttdata.banca.model.Service.AsociationService;
import com.nttdata.banca.model.document.*;
import com.nttdata.banca.model.repository.AsociationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AsociationServiceImp implements AsociationService {

    @Autowired
    AsociationRepository asociationRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Override
    public Flux<Asociation> findAll() {
        return asociationRepository.findAll();
    }

    @Override
    public Mono<Asociation> create(String idCustomer, String idProduct, float amount) {
        Asociation asociation = new Asociation();
        RestTemplate restTemplate=new RestTemplate();
       /* List<Asociation> list = Collections.singletonList(asociation);
        list.stream().map(x->{*/
        Customer customer=restTemplate.getForObject("http://localhost:8085/mngcustomers/cus/"+idCustomer, Customer.class);
        CategoryCustomer categoryCustomer=restTemplate.getForObject("http://localhost:8085/mngcustomers/cat/"+customer.getIdCategory(), CategoryCustomer.class);
        Product product=restTemplate.getForObject("http://localhost:8086/mngproducts/pro/"+idProduct, Product.class);
        CategoryProduct categoryProduct=restTemplate.getForObject("http://localhost:8086/mngproducts/cat/"+product.getIdCategory(), CategoryProduct.class);
            /*Customer customer = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8085/mngcustomers/cus/"+idCustomer)
                    .retrieve()
                    .bodyToMono(Customer.class)
                    .block();
            System.out.println("aa: "+customer.getName());
            CategoryCustomer categoryCustomer = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8085/mngcustomers/cat/"+customer.getIdCategory())
                    .retrieve()
                    .bodyToMono(CategoryCustomer.class)
                    .block();

            Product product = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8086/mngproducts/pro/"+idProduct)
                    .retrieve()
                    .bodyToMono(Product.class)
                    .block();

            CategoryProduct categoryProduct = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8086/mngproducts/cat/"+product.getIdCategory())
                    .retrieve()
                    .bodyToMono(CategoryProduct.class)
                    .block();*/


            asociation.setIdCustomer(idCustomer);
            asociation.setCustomer(customer.getName());
            asociation.setCategory_customer(categoryCustomer.getName());
            asociation.setIdProduct(idProduct);
            asociation.setProduct(product.getName());
            asociation.setCategory(categoryProduct.getName());
            asociation.setAmount(amount);


        return asociationRepository.save(asociation);

    }

    @Override
    public Mono<Asociation> findById(String id) {
        return asociationRepository.findById(id);
    }

    @Override
    public Mono<Asociation> update(Asociation asociation) {
        return asociationRepository.save(asociation);
    }

    @Override
    public Mono<Boolean> existsById(String id) {
        return asociationRepository.existsById(id);
    }

    @Override
    public Mono<Void> delete(String id) {
        return asociationRepository.deleteById(id);
    }
}
