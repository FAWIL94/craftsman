package ch.zhaw.craftsman.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.craftsman.model.Customer;
import ch.zhaw.craftsman.model.CustomerCreateDTO;
import ch.zhaw.craftsman.repository.CustomerRepository;


@RestController
@RequestMapping("/api/customer")
public class CostumerController {
    @Autowired 
    CustomerRepository customerRepository;

    @PostMapping("")
    public ResponseEntity<Customer> createCustomer(
        @RequestBody CustomerCreateDTO fDTO) {
            Customer fDAO = new Customer(fDTO.getEmail(), fDTO.getName()); 
            Customer c = customerRepository.save(fDAO); 
            return new ResponseEntity<>(c, HttpStatus.CREATED); 
        }
    @GetMapping("")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        List<Customer> allCustomer = customerRepository.findAll();
        return new ResponseEntity<>(allCustomer, HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Customer> getCustomerByID(@PathVariable String id) {
        Optional<Customer> optCustomer = customerRepository.findById(id);
        if (optCustomer.isPresent()) {
            return new ResponseEntity<>(optCustomer.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } 
}
}
