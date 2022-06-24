package com.nttdata.banca.model.repository;

import com.nttdata.banca.model.document.Asociation;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsociationRepository extends ReactiveMongoRepository<Asociation,String > {
}
