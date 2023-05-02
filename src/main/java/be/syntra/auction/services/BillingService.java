package be.syntra.auction.services;

import be.syntra.auction.domain.BillingDetails;

import java.math.BigDecimal;
import java.util.List;

public interface BillingService {

    List<BillingDetails> findByUserId(Long userId);

    void pay(Long userId, BigDecimal amount);

}
