package be.syntra.auction.repositories;

import be.syntra.auction.domain.BillingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;


public interface BillingRepository<T extends BillingDetails, Long> extends JpaRepository<T, Long> {

    List<BillingDetails> findByUserId (Long userId);
    Optional<T> findById(Long id);


}
