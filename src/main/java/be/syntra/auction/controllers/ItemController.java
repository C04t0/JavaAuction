package be.syntra.auction.controllers;

import be.syntra.auction.domain.Bid;
import be.syntra.auction.domain.Image;
import be.syntra.auction.domain.Item;
import be.syntra.auction.services.ItemServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/items")
public class ItemController {

    private ItemServiceImpl itemService;

    @GetMapping("/{id}/bids")
    public ResponseEntity<List<Bid>> getBidsFromItem(@PathVariable Long id) {
        return new ResponseEntity<>(itemService.findById(id).getBids(), HttpStatus.OK);
    }

    @GetMapping("/{id}/images")
    public ResponseEntity<List<Image>> getImagesFromItem(@PathVariable Long id) {
        return new ResponseEntity<>(itemService.findImageByItem_Id(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Item>> findAllItems() {
        return new ResponseEntity<>(itemService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<List<Item>> findItemsByAuctionEndDate(@RequestParam LocalDate auctionEndDate) {
        return new ResponseEntity<>(itemService.findByAuctionEndDate(auctionEndDate), HttpStatus.OK);
    }

    @PostMapping("/{id}/placebid")
    public ResponseEntity<HttpStatus> placeBid(@PathVariable Long id, @Valid @RequestBody Bid bid) {
        itemService.placeBid(id, bid);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
