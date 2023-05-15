package be.syntra.auction.controllers;

import be.syntra.auction.services.BillingServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@AllArgsConstructor
@RestController
public class BillingController {

    private BillingServiceImpl billingService;

    @PostMapping("/users/{id}/pay")
    public ResponseEntity<HttpStatus> pay(@PathVariable Long id, @Valid @RequestParam BigDecimal amount) {
        billingService.pay(id, amount);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
