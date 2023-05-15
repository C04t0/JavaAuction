package be.syntra.auction.services;

import be.syntra.auction.domain.Bid;
import be.syntra.auction.domain.BillingDetails;
import be.syntra.auction.domain.Image;
import be.syntra.auction.domain.Item;

import java.time.LocalDate;
import java.util.List;

public interface ItemService {

    void placeBid(Long id, Bid bid);
    void deleteItem(Long id);
    void createItem(Item item);
    Item findById(Long id);
    List<Item> findByName(String name);
    List<Item> findAll();
    List<Image> findImageByItem_Id(Long id);
    List<Item> findByAuctionEndDate(LocalDate auctionEndDate);

}
