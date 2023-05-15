package be.syntra.auction.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
public class MainController {
    @GetMapping()
    public ResponseEntity<HttpStatus> showMainPage() {
        System.out.println("Welcome to the JavaAuction.");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
