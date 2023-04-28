package be.syntra.auction.services;

import be.syntra.auction.repositories.BillingRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Transactional
public class BillingServiceImpl implements BillingService {

    private BillingRepository billingRepository;

}
