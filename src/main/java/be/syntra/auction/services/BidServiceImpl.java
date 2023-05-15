package be.syntra.auction.services;

import be.syntra.auction.domain.Bid;
import be.syntra.auction.repositories.BidRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@AllArgsConstructor
@Service
public class BidServiceImpl implements BidService {

    private BidRepository bidRepository;

    @Override
    public Set<Bid> findByItemIdSortedHigh(Long itemId) {
        return bidRepository.findByItem_IdOrderByAmount(itemId);
    }
}
