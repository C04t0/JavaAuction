package be.syntra.auction.services;

import be.syntra.auction.domain.BillingDetails;
import be.syntra.auction.exceptions.EntityNotFoundException;
import be.syntra.auction.repositories.BillingRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Transactional
public class BillingServiceImpl implements BillingService {

    private BillingRepository billingRepository;

    @Override
    public List<BillingDetails> findByUserId(Long userId) {
        return billingRepository.findByUserId(userId);
    }

    @Override
    public void pay(Long id, BigDecimal amount) {
        Optional<BillingDetails> entity = billingRepository.findById(id);
        BillingDetails billingDetails = unwrapBillings(entity, id);
        billingDetails.pay(amount);
    }

    public static BillingDetails unwrapBillings(Optional<BillingDetails> entity, Long id) {
        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new EntityNotFoundException(id, BillingDetails.class);
        }
    }
}
