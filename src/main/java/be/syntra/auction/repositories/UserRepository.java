package be.syntra.auction.repositories;

import be.syntra.auction.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserRepository extends JpaRepository<User, Long> {
        Optional<User> findByUsername(String username);
        List<User> findAll();
        void deleteById(Long id);
}
