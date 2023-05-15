package be.syntra.auction.services;

import be.syntra.auction.domain.Bid;
import be.syntra.auction.domain.BillingDetails;
import be.syntra.auction.domain.Image;
import be.syntra.auction.domain.Item;
import be.syntra.auction.exceptions.EntityNotFoundException;
import be.syntra.auction.repositories.ImageRepository;
import be.syntra.auction.repositories.ItemRepository;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;

    private ImageRepository imageRepository;
    @Override
    public Item findById(Long id) {
        Optional<Item> entity = itemRepository.findById(id);
        return unwrapItem(entity, id);
    }
    @Override
    public List<Item> findByName(String name) {
        return itemRepository.findByNameContainsIgnoreCase(name);
    }
    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }
    @Override
    public List<Image> findImageByItem_Id(Long id) {
        return imageRepository.findByItem_Id(id);
    }

    @Override
    public void createItem(Item item) {
        itemRepository.save(item);
    }

    @Override
    public void placeBid(Long id, Bid bid) {
        Optional<Item> entity = itemRepository.findById(id);
        ItemServiceImpl.unwrapItem(entity, id).getBids().add(bid);
    }
    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
    @Override
    public List<Item> findByAuctionEndDate(LocalDate auctionEndDate) {
        return itemRepository.findByAuctionEndDate(auctionEndDate);
    }

    public static Item unwrapItem(Optional<Item> entity, Long id) {
        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new EntityNotFoundException(id, Item.class);
        }
    }


}
