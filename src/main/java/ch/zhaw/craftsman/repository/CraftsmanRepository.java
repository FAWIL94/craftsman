package ch.zhaw.craftsman.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ch.zhaw.craftsman.model.Craftsman;

public interface CraftsmanRepository extends MongoRepository<Craftsman,String> {
    
}
