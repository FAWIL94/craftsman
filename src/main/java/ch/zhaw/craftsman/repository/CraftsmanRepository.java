package ch.zhaw.craftsman.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import ch.zhaw.craftsman.model.Craftsman;
import ch.zhaw.craftsman.model.CraftsmanCustomerAggregationDTO;
import ch.zhaw.craftsman.model.CraftsmanStateAggregationDTO;

public interface CraftsmanRepository extends MongoRepository<Craftsman,String> {
    List<Craftsman> findByPriceGreaterThan(Double price);

    @Aggregation("{$group: {_id: '$craftsmanState',craftsmanId: {$push: '$_id'},count: {$count: {}}}}")
    List<CraftsmanStateAggregationDTO> getCraftsmanStateAggregation();
    
    @Aggregation("{$group: {_id: '$customerId',craftsmanId: {$push: '$_id'},totalPrice: {$sum: '$price'}}}")
    List<CraftsmanCustomerAggregationDTO> getCraftsmanCustomerAggregation();
}
