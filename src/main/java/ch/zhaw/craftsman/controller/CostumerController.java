package ch.zhaw.craftsman.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.craftsman.repository.CustomerRepository;
import model.Customer;
import model.CustomerCreateDTO;


@RestController 
public class CostumerController {
    @Autowired 
    CustomerRepository customerRepository;

    @PostMapping("/customer")
    public ResponseEntity<Customer> createCustomer(
        @RequestBody CustomerCreateDTO fDTO) {
            Customer fDAO = new Customer(fDTO.getEmail(), fDTO.getName()); 
            Customer c = customerRepository.save(fDAO); 
            return new ResponseEntity<>(c, HttpStatus.CREATED); 
        }
    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        List<Customer> allCustomer = customerRepository.findAll();
        return new ResponseEntity<>(allCustomer, HttpStatus.OK);
    }
}
