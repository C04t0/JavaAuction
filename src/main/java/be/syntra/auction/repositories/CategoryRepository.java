package be.syntra.auction.repositories;

import be.syntra.auction.domain.Category;
import be.syntra.auction.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findById(Long id);

}
