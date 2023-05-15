package be.syntra.auction.repositories;

import be.syntra.auction.domain.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface BidRepository extends JpaRepository<Bid, Long> {


    Set<Bid> findByItem_IdOrderByAmount(Long itemId);
}
