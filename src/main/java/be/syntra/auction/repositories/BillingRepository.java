package be.syntra.auction.repositories;

import be.syntra.auction.domain.BillingDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingRepository extends JpaRepository<BillingDetails, Long> {
}
