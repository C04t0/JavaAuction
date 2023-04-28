package be.syntra.auction.repositories;

import be.syntra.auction.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;


public interface ItemRepository extends JpaRepository<Item, Long> {

    void deleteById(Long id);

    List<Item> findByAuctionEndDate(LocalDate auctionEndDate);
    Item findByNameContainsIgnoreCase(String name);

}
