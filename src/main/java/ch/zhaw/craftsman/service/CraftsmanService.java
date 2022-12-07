package ch.zhaw.craftsman.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.zhaw.craftsman.model.Craftsman;
import ch.zhaw.craftsman.repository.CraftsmanRepository;
import ch.zhaw.craftsman.repository.CustomerRepository;
import ch.zhaw.craftsman.model.CraftsmanState;
@Service
public class CraftsmanService {
    @Autowired
    CraftsmanRepository craftsmanRepository;

    @Autowired
    CustomerRepository customerRepository;

        
    public Optional<Craftsman> assignCraftsman(String craftsmanId, String customerId) {
        if (customerRepository.findById(customerId).isPresent()) {
            Optional<Craftsman> craftsmanToAssign = craftsmanRepository.findById(craftsmanId);
            if (craftsmanToAssign.isPresent()) {
                Craftsman craftsman = craftsmanToAssign.get();
                if (craftsman.getCraftsmanState() == CraftsmanState.NEW) {
                    craftsman.setCraftsmanState(CraftsmanState.ASSIGNED);
                    craftsman.setCustomerId(customerId);
                    craftsmanRepository.save(craftsman);
                    return Optional.of(craftsman);
                }
            }
        }
        return Optional.empty();
    }

    public Optional<Craftsman> completeOrder(String craftsmanId, String comment) {
        Optional<Craftsman> orderToComplete = craftsmanRepository.findById(craftsmanId);
        if (orderToComplete.isPresent()) {
            Craftsman craftsman = orderToComplete.get();
            if (craftsman.getCraftsmanState() == CraftsmanState.ASSIGNED) {
                craftsman.setCraftsmanState(CraftsmanState.DONE);
                craftsman.setComment(comment);
                craftsmanRepository.save(craftsman);
                return Optional.of(craftsman);
            }
        }
        return Optional.empty();
    }
}