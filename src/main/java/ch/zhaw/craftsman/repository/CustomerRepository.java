package ch.zhaw.craftsman.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import model.Customer;

public interface CustomerRepository extends MongoRepository<Customer,String>  {
    
}
