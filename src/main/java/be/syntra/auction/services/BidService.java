package be.syntra.auction.services;

import be.syntra.auction.domain.Bid;

import java.util.List;
import java.util.Set;

public interface BidService {

    Set<Bid> findByItemIdSortedHigh(Long itemId);
}
