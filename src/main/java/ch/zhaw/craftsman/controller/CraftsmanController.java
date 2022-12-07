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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.craftsman.model.Craftsman;
import ch.zhaw.craftsman.model.CraftsmanCreateDTO;
import ch.zhaw.craftsman.model.CraftsmanCustomerAggregationDTO;
import ch.zhaw.craftsman.model.CraftsmanStateAggregationDTO;
import ch.zhaw.craftsman.repository.CraftsmanRepository;

@RestController
@RequestMapping("/api/craftsman")
public class CraftsmanController {
    @Autowired
    CraftsmanRepository craftsmanRepository;

    @PostMapping("")
    public ResponseEntity<Craftsman> createCraftsman(
            @RequestBody CraftsmanCreateDTO cDTO) {
        Craftsman cDAO = new Craftsman(cDTO.getCompanyname(), cDTO.getStreet(), cDTO.getPlz(), cDTO.getPlace(),
                cDTO.getPrice());
        Craftsman m = craftsmanRepository.save(cDAO);
        return new ResponseEntity<>(m, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<Craftsman>> getAllCustomers() {
        List<Craftsman> allCraftsmans = craftsmanRepository.findAll();
        return new ResponseEntity<>(allCraftsmans, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Craftsman> getCraftmanbyId(@PathVariable String id) {
        Optional<Craftsman> optCraftsman = craftsmanRepository.findById(id);
        if (optCraftsman.isPresent()) {
            return new ResponseEntity<>(optCraftsman.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/priceabove")
    public ResponseEntity<List<Craftsman>> getPriceabovce(@RequestParam Double min) {
        return new ResponseEntity<>(craftsmanRepository
                .findByPriceGreaterThan(min), HttpStatus.OK);
    }
    @GetMapping("/bystate")
    public ResponseEntity<List<CraftsmanStateAggregationDTO>> getCraftsmanStateAggregation() {
        return new ResponseEntity<>(craftsmanRepository.getCraftsmanStateAggregation(), HttpStatus.OK);
    }
    @GetMapping("/bycustomer")
    public ResponseEntity<List<CraftsmanCustomerAggregationDTO>> getCraftsmanCustomerAggregation() {
        return new ResponseEntity<>(craftsmanRepository.getCraftsmanCustomerAggregation(), HttpStatus.OK);
    }

}
