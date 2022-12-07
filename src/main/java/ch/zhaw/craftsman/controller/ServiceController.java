package ch.zhaw.craftsman.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.craftsman.model.Craftsman;
import ch.zhaw.craftsman.model.CraftsmanAssignDTO;
import ch.zhaw.craftsman.model.CraftsmannCompleteDTO;
import ch.zhaw.craftsman.service.CraftsmanService;

@RestController
@RequestMapping("/api/service")
public class ServiceController {
    @Autowired
    CraftsmanService craftsmanService;

    @PostMapping("/craftmanassignment")
    public ResponseEntity<Craftsman> assignCraftsman(@RequestBody CraftsmanAssignDTO assignDTO) {
        Optional<Craftsman> craftman = craftsmanService.assignCraftsman(assignDTO.getCraftsmanId(), assignDTO.getCustomerId());
        if (craftman.isPresent()) {
            return new ResponseEntity<>(craftman.get(), HttpStatus.OK); 
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/ordercomplete")
    public ResponseEntity<Craftsman> completeOrder(@RequestBody CraftsmannCompleteDTO completeDTO) {
        Optional<Craftsman> craftsman = craftsmanService.completeOrder(completeDTO.getCraftsmanId(), completeDTO.getComment());
        if (craftsman.isPresent()) {
            return new ResponseEntity<>(craftsman.get(), HttpStatus.OK); 
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
   
}
