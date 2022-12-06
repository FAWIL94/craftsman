package ch.zhaw.craftsman.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import ch.zhaw.craftsman.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer,String>  {
    
}
